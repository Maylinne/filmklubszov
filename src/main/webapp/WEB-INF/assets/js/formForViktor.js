var _formForViktor = undefined;

(function(module) {
	$(document).ready(
			function() {
				
				if($("#serverNotifMessage").html() && $("#serverNotifType").html()) {
					var notif = $(".serverNotification");
					notif.addClass("alert-"+$("#serverNotifType").html());
					$(".notifMessage").html($("#serverNotifMessage").html());
					notif.show();
				}
				
				$("#userList").on("click", function() {
					window.location.href=$("head base").attr("href")+"users";
				})

				$(".userTable").on("click", ".deleteUser", function() {
					var userId = $(this).attr("data-userId");
					var loc = window.location.origin + "/fksz/users";
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod a felhasználót?", function(){
						$.ajax({
							method : "POST",
							url : "users/deleteuserpost",
							data : {
								userId : userId
							},
							success : function(data) {
								if (data == "" || data == null) {
									window.location.href = loc;
								} else {
									alert(data);
								}
							}
						});
					});
				})
				
				
				$(".offerTable").on("click", ".deleteOffer", function() {
					var offerId = $(this).attr("data-offerId");
					var loc = window.location.href;
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod az ajánlatot?", function(){
						$.ajax({
							method : "POST",
							url : "offers/deleteofferpost",
							data : {
								offerId : offerId
							},
							success : function(data) {
								window.location.href = loc;
							}
						});
					});
					
				})
				
				$(".locationTable").on("click", ".deleteLocation", function() {
					var locationId = $(this).attr("data-locationId");
					var loc = window.location.origin + "/fksz/locations";
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod a helyszint?", function(){
						$.ajax({
							method : "POST",
							url : "locations/deletelocationpost",
							data : {
								locationId : locationId
							},
							success : function(data) {
								if (data == "" || data == null) {
									window.location.href = loc;
								} else {
									alert(data);
								}
							}
						});
					});
				})
				
				$(".locationTable").on("click", ".deleteSpot", function() {
					var spotId = $(this).attr("data-spotId");
					var loc = window.location.origin + "/fksz/locations";
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod a termet?", function(){	
						$.ajax({
							method : "POST",
							url : "locations/deletespotpost",
							data : {
								spotId : spotId
							},
							success : function(data) {
								if (data == "" || data == null) {
									window.location.href = loc;
								} else {
									alert(data);
								}
							}
						});
					});
				})
				
				$(".movieTable").on("click", ".deleteFilm", function() {
					var filmMetaId = $(this).attr("data-filmMetaId");
					var loc = window.location.origin + "/fksz/movies";
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod a filmet?", function(){
						$.ajax({
							method : "POST",
							url : "movies/deletemoviepost",
							data : {
								filmMetaId : filmMetaId
							},
							success : function(data) {
								if (data == "" || data == null) {
									window.location.href = loc;
								} else {
									alert(data);
								}
							}
						});
					});
				})
				
				$(".movieTable").on("click", ".deleteCut", function() {
					var cutId = $(this).attr("data-cutId");
					var loc = window.location.origin + "/fksz/movies";
					_dialogHelper.ShowConfirmation("Törlés megerősitése", "Biztos, hogy törölni akarod akópiát?", function(){
						$.ajax({
							method : "POST",
							url : "movies/deletecutpost",
							data : {
								cutId : cutId
							},
							success : function(data) {
								if (data == "" || data == null) {
									window.location.href = loc;
								} else {
									alert(data);
								}
							}
						});
					});
				})
				

				$(".userTable").on("click", ".sendEmail", function() {
					var userId = $(this).attr("data-userId");
					$.ajax({
						method : "POST",
						url : "users/sendregisteremail",
						data : {
							userId : userId
						},
						success : function(result) {
							alert("Az email elment.");
						}
					});
				})
				
				$(".userTable").on("click", ".editUser", function() {
					var userId = $(this).attr("data-userId");
					var loc = window.location.href;
					$.ajax({
						method : "POST",
						url : "users/edituserdialogpost",
						data : {
							userId : userId
						},
						success : function(data) {
							var user = JSON.parse(data);
							$("#Id" ,$(".modal-body form")).val(user.id);
							$("#Email" ,$(".modal-body form")).val(user.email);
							$("#Name" ,$(".modal-body form")).val(user.name);
							$("#roleSelect" ,$(".modal-body form")).val(user.role);
							$("#addUser_modal").modal("show");
						}
					});
				})
				
				$(".locationTable").on("click", ".editLocation", function() {
					var locationId = $(this).attr("data-locationId");
					var loc = window.location.href;
					$.ajax({
						method : "POST",
						url : "locations/editlocationdialogpost",
						data : {
							locationId : locationId
						},
						success : function(data) {
							var location = JSON.parse(data);
							$("#Id" ,$(".modal-body form")).val(location.id);
							$("#Name" ,$(".modal-body form")).val(location.name);
							$("#City" ,$(".modal-body form")).val(location.city);
							$("#Address" ,$(".modal-body form")).val(location.address);
							$("#addLocation_modal").modal("show");
						}
					});
				})
				
				$(".locationTable").on("click", ".editSpot", function() {
					var spotId = $(this).attr("data-spotId");
					var loc = window.location.href;
					$.ajax({
						method : "POST",
						url : "locations/editspotdialogpost",
						data : {
							spotId : spotId
						},
						success : function(data) {
							var spot = JSON.parse(data);
							$("#LocationId" ,$(".modal-body form")).val(spot.locationId);
							$("#SpotId" ,$(".modal-body form")).val(spot.id);
							$("#Name" ,$(".modal-body form")).val(spot.name);
							$("#Places" ,$(".modal-body form")).val(spot.places);
							$("#addSpot_modal").modal("show");
						}
					});
				})
				
				$(".movieTable").on("click", ".editFilm", function() {
					var filmMetaId = $(this).attr("data-filmMetaId");
					var loc = window.location.href;
					$.ajax({
						method : "POST",
						url : "movies/editmoviedialogpost",
						data : {
							filmMetaId : filmMetaId
						},
						success : function(data) {
							var movie = JSON.parse(data);
							var movieBodyForm = $(".modal-body form", $("#addFilm_modal")); 
							$("#Id" ,movieBodyForm).val(movie.id);
							$("#Title" ,movieBodyForm).val(movie.title);
							$("#HungarianTitle" ,movieBodyForm).val(movie.hungarianTitle);
							$("#Director" ,movieBodyForm).val(movie.director);
							$("#addFilm_modal").modal("show");
						}
					});
				})
				
				
				$(".movieTable").on("click", ".editCut", function() {
					var cutId = $(this).attr("data-cutId");
					var loc = window.location.href;
					$.ajax({
						method : "POST",
						url : "movies/editcutdialogpost",
						data : {
							cutId : cutId
						},
						success : function(data) {
							var cut = JSON.parse(data);
							var cutBodyForm = $(".modal-body form", $("#addCut_modal"));
							$("#Id" ,cutBodyForm).val(cut.cutId);
							$("#FilmMetaId" ,cutBodyForm).val(cut.filmMetaId);
							$("#Title" ,cutBodyForm).val(cut.title);
							$("#HungarianTitle" ,cutBodyForm).val(cut.hungarianTitle);
							$("#Length" ,cutBodyForm).val(cut.length);
							$("#Year" ,cutBodyForm).val(cut.year);
							$("#addCut_modal").modal("show");
						}
					});
				})
				
				module.hideInners();

				// Bind list buttons
				$(".expandButton").click(function() {
					module.toggleInners($(this).closest(".outer-table-row"));
					$("i", $(this)).toggleClass("reverse");
				});

				
				$(".addCut").click(
						function() {
							var filmMetaId = $(this).attr("data-filmMetaId");
							$("#FilmMetaId", $("#addCut_modal"))
									.val(filmMetaId);
						})
				
				$(".addSpot").click(
						function() {
							var locationId = $(this).attr("data-locationId");
							$("#LocationId", $("#addSpot_modal")).val(
									locationId);
						})
				
				$(".editFilm").click(
						function() {
							var filmMetaId = $(this).closest("tr").attr(
									"data-filmMetaId");
							module.GetFilmModal(filmMetaId);
						})
						
				$(".editLocation").click(
						function() {
							var filmMetaId = $(this).closest("tr").attr(
									"data-filmMetaId");
							module.GetFilmModal(filmMetaId);
						})
						
				//OBSOLETE
				// Bind nav buttons
				$(".formNavButton").click(function(e) {
					var id = $(this).attr("data-formId");

					module.HideForms(id + "Form");
					module.ActivateNavButtons(id);
					e.preventDefault();
				})
				//OBSOLETE
				$(".saveJson").click(
						function(e) {
							var activeFormID = $(".ft_formelement.active")
									.attr("id");
							var json = "";
							if (activeFormID == "movieForm") {
								var form = $(".ft_formelement.active :input");
								json = module.serializeFormJSON(form
										.serializeArray());
							} else {
								var venue = {};
								$.each($(".venuesHead :input"),
										function() {
											venue[$(this).attr("name")] = $(
													this).val();
										});

								var spots = $("tr", $(".spotTable"));

								if (spots.length) {
									venue["spots"] = [];
								}

								for (var i = 0; i < spots.length; i++) {
									var spot = {};
									$.each($(":input", spots[i]), function() {
										spot[$(this).attr("name")] = $(this)
												.val();
									});

									venue.spots[i] = spot;
								}
								json = venue;
							}

							$('#forTheJson p').text("").text(
									JSON.stringify(json, null, '\n'));
						})

				$(".myButton").click(module.AddSpot);

			});

	module.hideInners = function(){
		$(".inner-rows").hide();
	}
	
	module.toggleInners = function(outer){
		$(outer).next($(".inner-rows")).toggle(200);
	}
	
	// Film list ajax
	module.GetFilmModal = function(filmMetaId) {
		$.ajax({
			url : "movies/getfilmmetabyid",
			data : {
				id : filmMetaId
			},
			headers : {
				Accept : "application/json"
			},
			contentType : 'application/json',
			method : 'GET',
			success : function(data) {
				alert('success');
			}
		})
	}
	//OBSOLETE
	module.deleteRow = function() {
		$(this).closest('tr').remove();
	}
	//OBSOLETE
	module.ActivateNavButtons = function(buttonId) {
		$(".formNavButton").removeClass("active");
		$("#" + buttonId + "Button").addClass("active");
	}
	//OBSOLETE
	module.HideForms = function(formId) {
		$(".formElement").removeClass("active");
		$("#" + formId).addClass("active");
	}
	//OBSOLETE
	module.AddSpot = function() {
		var spotTable = $(".myTable");
		var spotRow = $("<tr></tr>");
		var spotTd = $("<td></td>");
		var spotDiv = '<div class="row">'
				+ '<div class="col-md-9">'
				+ '<label>Terem neve</label>'
				+ '<input type="text" name="spotName" class="spotName form-control">'
				+ '</div>'
				+ '<div class="col-md-3">'
				+ '<label>Ülőhely</label>'
				+ '<input type="number" name="seats" class="seats form-control">'
				+ '</div>'
				+ '</div>'
				+ '<div class="row">'
				+ '<div class="col-md-12">'
				+ '<label>Hangtechnika</label>'
				+ '<input type="text" name="audioFeatures" class="audio form-control">'
				+ '</div>'
				+ '</div>'
				+ '<div class="row">'
				+ '<div class="col-md-12">'
				+ '<label>Képtechnika</label>'
				+ '<input type="text" name="videoFeatures" class="video form-control">'
				+ '</div>' + '</div>';

		spotTd.html(spotDiv);
		spotRow.append(spotTd);
		spotTable.append(spotRow);

	}
	//OBSOLETE
	module.serializeFormJSON = function(form) {

		var o = {};
		$.each(form, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

})(_formForViktor || (_formForViktor = {}));




var _dialogHelper = undefined;

(function (module) {
	module.dialog = undefined;
	
	$(document).ready(function() {
		module.dialog = $("#confirmation_modal");
		
		$("#confirmation_modal").on('hidden.bs.modal', function (e) {
			module.resetDialog();
		});
	})
	
	module.resetDialog = function() {
		$("#confirm-title", module.dialog).html("");
		$("#confirm-info", module.dialog).html("");
		$("#confirm-yes").unbind("click");
	}
	
	module.ShowConfirmation = function(title, description, callback) {
		$("#confirm-title", module.dialog).html(title);
		$("#confirm-info", module.dialog).html(description);
		
		module.dialog.modal("show");
		
		$("#confirm-yes").click(function (){
			if(callback) callback();
		});
	}

}) (_dialogHelper || (_dialogHelper = {}));
