var _formForViktor = undefined;

(function (module) {
    $(document).ready(function () {
        $("#movieForm").addClass("active").show();


		$(".subTableRow").hide();

		//Bind list buttons
		$(".expandButton").click(function() {
			$(this).closest("tr").next("tr").toggle();
			$("i", $(this)).toggleClass("reverse");
		});
		
		$(".cutModal").click(function(){
			var filmMetaId = $(this).closest(".subTableRow").attr("data-filmMetaId");
			$("#FilmMetaId", $("#addCut_modal")).val(filmMetaId);
		})
		
		$(".spotModal").click(function(){
			var locationId = $(this).closest(".subTableRow").attr("data-locationId");
			$("#LocationId", $("#addSpot_modal")).val(locationId);
		})
		
		$(".editFilm").click(function(){
			var filmMetaId = $(this).closest("tr").attr("data-filmMetaId");
			module.GetFilmModal(filmMetaId);
		})
        
        //Bind nav buttons
        $(".formNavButton").click(function (e) {
            var id = $(this).attr("data-formId");

            module.HideForms(id + "Form");
            module.ActivateNavButtons(id);
            e.preventDefault();
        })

        $(".saveJson").click(function (e) {
            var activeFormID = $(".ft_formelement.active").attr("id");
            var json = "";
            if (activeFormID == "movieForm") {
                var form = $(".ft_formelement.active :input");
                json = module.serializeFormJSON(form.serializeArray());
            }
            else {
                var venue = { };
                $.each($(".venuesHead :input"), function () {
                    venue[$(this).attr("name")] = $(this).val();
                });

                var spots = $("tr", $(".spotTable"));

                if (spots.length) {
                    venue["spots"] = [];
                }

                for (var i = 0; i < spots.length; i++) {
                    var spot = { };
                    $.each($(":input", spots[i]), function () {
                        spot[$(this).attr("name")] = $(this).val();
                    });

                    venue.spots[i] = spot;
                }
                json = venue;
            }

            $('#forTheJson p').text("").text(JSON.stringify(json, null, '\n'));
        })

        $(".myButton").click(module.AddSpot);


    });
    
    //Film list ajax
    module.GetFilmModal = function (filmMetaId) {
    	$.ajax({
    		url: "addmovie2/getfilmmetabyid",
    		data: {id: filmMetaId},
    		headers: { 
    		    Accept : "application/json"
    		},
    		contentType: 'application/json',
    		method: 'GET',
    		success: function(data) {
    			alert('success');
    		}
    	})
    }
    

    module.deleteRow = function () {
        $(this).closest('tr').remove();
    }

    module.ActivateNavButtons = function (buttonId) {
        $(".formNavButton").removeClass("active");
        $("#" + buttonId + "Button").addClass("active");
    }

    module.HideForms = function (formId) {
        $(".formElement").removeClass("active").hide();
        $("#" + formId).addClass("active").show();
    }

    module.AddSpot = function () {
        var spotTable = $(".myTable");
        var spotRow = $("<tr></tr>");
        var spotTd = $("<td></td>");
        var spotDiv = '<div class="row">' +
                        '<div class="col-md-9">' +
                            '<label>Terem neve</label>' +
                            '<input type="text" name="spotName" class="spotName form-control">' +
                        '</div>' +
                        '<div class="col-md-3">' +
                            '<label>Ülőhely</label>' +
                            '<input type="number" name="seats" class="seats form-control">' +
                        '</div>' +
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-md-12">' +
                                '<label>Hangtechnika</label>' +
                                '<input type="text" name="audioFeatures" class="audio form-control">' +
                            '</div>' +
                       '</div>' +
                       '<div class="row">' +
                            '<div class="col-md-12">' +
                                '<label>Képtechnika</label>' +
                                '<input type="text" name="videoFeatures" class="video form-control">' +
                            '</div>'+
                        '</div>';

        spotTd.html(spotDiv);
        spotRow.append(spotTd);
        spotTable.append(spotRow);

    }

    module.serializeFormJSON = function (form) {

        var o = {};
        $.each(form, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

})(_formForViktor || (_formForViktor = {}));
