package fksz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import fksz.dao.UserDao;
import fksz.domain.MyUserPrincipal;
import fksz.domain.User;
import fksz.domain.UserStatus;
import fksz.dto.UserDto;
import fksz.requests.ChangePswRequest;
import fksz.transformers.UserTransformer;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	UserDao dao;

	@Autowired
	UserTransformer transformer;

	@Autowired
	BCryptPasswordEncoder pswEncoder;
	
	public void save(UserDto dto) {
		dao.save(transformer.dtoToEntity(dto));
	}

	public void saveAll(List<UserDto> dtos) {
		dao.save(transformer.dtosToEntities(dtos));
	}

	public void delete(UserDto dto) {
		dao.delete(transformer.dtoToEntity(dto));
	}

	public void deleteById(Integer id) {
		dao.delete(id);
	}

	public UserDto getById(Integer id) {
		return transformer.entitytoDto(dao.findById(id));
	}
	
	public UserDto getByName(String name) {
		return transformer.entitytoDto(dao.findByName(name));
	}

	public List<UserDto> getAll() {
		return transformer.entiesToDtos(dao.findAll());
	}

	public Map<Integer, String> allTheAvailableUsers() {
		Map<Integer, String> availableUsers = new HashMap<>();
		for (UserDto user : getAll()) {
			if (user.getRole().equals("ROLE_ADMIN") || user.getRole().equals("ROLE_VENDOR")) {
				availableUsers.put(user.getId(), user.getName());
			}
		}
		return availableUsers;
	}

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = dao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new MyUserPrincipal(user);
	}

	public String generateNewPassword() {
		String newPassword = new String();
		String genpart = UUID.randomUUID().toString();
		newPassword = genpart.substring(2, 7) + "gen";
		return newPassword;
	}

	public String changeUserPassword(ChangePswRequest request) {
		UserDto user = getById(request.getUserId());
		String checkString = checkPswChangeble(request, user);
		if (checkString.equals("A jelszó megváltozott.")) {
			user.setPassword(request.getNewPsw());
			if (user.getStatus() == UserStatus.PENDING) {
				user.setStatus(UserStatus.ACTIVATED);
			}
			user.setPassword(request.getNewPsw());
			save(user);
		}
		return checkString;
	}

	private String checkPswChangeble(ChangePswRequest request, UserDto user) {
		boolean isOldPswOk = pswEncoder.matches(request.getOldPsw(), user.getPassword());
		boolean isNewPswLongEnough = request.getNewPsw().length() >= 8;
		boolean areNewPswsTheSame = request.getNewPsw().equals(request.getNewPswAgain());
		if(!isOldPswOk) {
			return "A régi jelszó nem egyezik meg a jelenlegivel";
		}else if (!isNewPswLongEnough) {
			return "Az új jelszó nem elég hosszú.";
		} else if (!areNewPswsTheSame) {
			return "Az új jelszavak nem egyeznek meg.";
		} else return "A jelszó megváltozott.";
	}
	
	public void generateAndSendRegistrationEmailWithNewPassword(int userId) {
		UserDto user = getById(userId);
		user.setStatus(UserStatus.PENDING);
		user.setPassword(generateNewPassword());
		save(user);
		try {
			sendRegisterEmail(user.getEmail(), generateRegisterEmailBody(user), user);
		} catch (MessagingException e) {
			System.out.println("Valahol hiba van a generálás/küldésben.");
			e.printStackTrace();
		}
	}

	public String generateRegisterEmailBody(UserDto user) {
		String emailBody = new String();
		emailBody = "Kedves " + user.getName() + "! <br/><br/>Önt beregisztrálták a <a href=\"http://filmklubszov.hu/profile\">filmklubszov.hu</a> oldalra ";
		emailBody = emailBody + getNiceUserRole(user.getRole()) + " szerepkörben. <br/>A generált jelszava: " + user.getPassword() + ". ";
		emailBody = emailBody + "Ezt az első belépést követően feltétlenül meg kell változtatnia.";
		emailBody = emailBody + "<br/><br/>Üdvözlettel: a Filmklubszövetség Titkársága";
		System.out.println(emailBody);
		return emailBody;
	}
	

	public void sendRegisterEmail(String email, String emailBody, UserDto user) throws MessagingException {
	
		String senderMail = "filmklubreg@gmail.com";
		String password = "FilmKlubReg2020";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderMail, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("filmklubreg@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("filmklubszov.hu regisztráció");
			message.setText(emailBody, "UTF-8", "html");
			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("The message cannot be sent.");
			throw new RuntimeException(e);
		}
		
	}
	
	private String getNiceUserRole(String role) {
		String niceRole = "";
		switch (role) {
		case "ROLE_ADMIN":
			niceRole = "adminisztrátor";
			break;
		case "ROLE_VENDOR":
			niceRole = "partner";
			break;
		case "ROLE_ORGANIZER":
			niceRole = "szervező";
			break;

		default:
			break;
		}
		return niceRole;
	}

	public boolean ifUserExistsByEmail(String email) {
		return dao.findByEmail(email) != null;
	}

}
