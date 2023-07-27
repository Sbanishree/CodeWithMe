<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"
	integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.5.3/css/bootstrap.min.css"
	integrity="sha512-oc9+XSs1H243/FRN9Rw62Fn8EtxjEYWHXRvjS43YtueEewbS6ObfXcJNyohjHqVKFPoXXUxwc+q1K7Dee6vv9g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.5.3/js/bootstrap.min.js"
	integrity="sha512-8qmis31OQi6hIRgvkht0s6mCOittjMa9GMqtK9hes5iEQBQE/Ca6yGE5FsW36vyipGoWQswBj/QBm2JR086Rkw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css"
	integrity="sha512-SEneLdQZVwXQTOQ/eoa8dYDmMzVbMG7JJiw1NW2ZFhNeunHX3Rjz7I7CvVFuoc8cTtN5TMzakgvBBj1AbswaNg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"
	integrity="sha512-SKbAu96njmWVMhYAJT5fcq1Ae5SxxKPukZj8TorqfqGC/3jqu69GYX39YT6OPpEQuDWjQmb4UIIqwr+c/ENbrA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
	<div class="container mt-4">
		<c:if test="${not empty msg}">
			<p class="alert alert-success">${msg}</p>
		</c:if>
		<div class="" style="background-color: #90ee90;">
			<h4>Insurance Claim Details</h4>
			<form action="./saveData" method="post"
				class="form-group w-50 m-auto" style="padding-top: 38px;">

				<div class="row">

					<div class="col-md-6">

						<label class="font-weight-bold"> Select Hospital<span
							class="text-danger">*</span>
						</label>

					</div>

					<div class="col-md-6">

						<select class="form-control" name="hospitalId" id="hospitalId"
							onchange="getDoctorByHospitalId(); getTableView();">
							<option value="0">--Select--</option>
							<c:forEach items="${hospitalList}" var="hospital">
								<option value="${hospital.hospitalId}">${hospital.hospitalName}</option>
							</c:forEach>
						</select>

					</div>

				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold"> Select Doctor</label>
					</div>

					<div class="col-md-6">

						<select class="form-control" id="doctorId" name="doctorId"
							onchange="getActivePatientByDocId();">
							<option value="0">--select--</option>


						</select>
					</div>
				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold"> Select Paitent</label>
					</div>

					<div class="col-md-6">

						<select class="form-control" id="patientId" name="patientId"
							onchange="getInsuranceByPatientId();">
							<option value="0">--select--</option>


						</select>
					</div>

				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold"> Insurance Name:<span
							id="insName"></span></label>
					</div>

					<div class="col-md-6">

						<label class="font-weight-bold">Insurance SchemeName:<span
							id="insSchemeName"></span></label>
					</div>

				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold"> Select Admission Date</label>
					</div>

					<div class="col-md-6">

						<input type="date" id="addId" name="admissionDate"
							class="form-control">
					</div>

				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold"> Select Discharge Date</label>
					</div>

					<div class="col-md-6">

						<input type="date" id="disId" name="dischargeDate"
							class="form-control">
					</div>

				</div>

				<div class="row mt-4">

					<div class="col-md-6">
						<label class="font-weight-bold">Enter Total Expenses</label>
					</div>

					<div class="col-md-6">

						<input type="text" id="expensesId" name="expensesId"
							class="form-control">


					</div>

				</div>

				<div class="row mt-4 pb-4">

					<div class="col-md-6"></div>

					<div class="col-md-6">

						<input type="submit" value="Save" class="btn btn-danger"
							style="width: 50%;" onclick="return validate();">

					</div>

				</div>








			</form>


		</div>

		<div>
			<table class="table table-responsive" id="tableId">
				<thead>
					<tr>
						<th>SLNo.</th>
						<th> Doctor Name</th>
                        <th>Patient Name</th>
					</tr>

				</thead>

				<tbody id="tableBody">
                   <tr> <td>1 </td> <td>wertyu </td> <td>wer5t6y</td></tr>
                   
                   

				</tbody>


			</table>


		</div>

	</div>

</body>

<script type="text/javascript">
	$(document).ready(function() {

        $("#tableId").hide();
	}

	);

	function getDoctorByHospitalId() {
		var hospitalId = $("#hospitalId").val();
		if (hospitalId != "0") {
			// ajax
			$.ajax({

				type : "POST",
				url : "./getDoctorByHospitalId",
				data : {
					hospId : hospitalId
				},
				success : function(response) {

					alert(response);
					console.log(response);
					var len = response.length;
					var html = '';
					var html1="";
					var count=1;
					debugger;
					for (var i = 0; i < len; i++) {
						html += '<option value="'+response[i].doctorId+'">'
								+ response[i].doctorName + '</option>';
						//html+='<option value="'++'">'++'</option>'
						
						html1+='<tr> <td>'+count+' </td> <td>'+response[i].doctorId+' </td> <td>'+response[i].doctorName+'</td></tr>';
						count++;

					}

					$("#doctorId").append(html);
					$("#tableBody").empty();
					$("#tableBody").append(html1);
					$("#tableId").show();

				}

			});

		} else {

			//alert("Please Select Hospital");
			$("#doctorId").val("0");

		}

	}

	function getActivePatientByDocId() {

		var doctorId = $("#doctorId").val();
		alert(doctorId);
		if (doctorId != "0") {
			$.ajax({
				type : "GET",
				url : "./getActivePatientByDocId",
				data : {

					docId : doctorId
				},
				success : function(response) {

					alert(response);
					console.log(response);
					var len = response.length;
					var html = "";
					for (var i = 0; i < len; i++) {

						// html +=''<option value="'+response[i].patientId+'">"+response[i].patientName+"</option>"

						html += '<option value="'+response[i].patientId+'">'
								+ response[i].patientName + '</option>'
					}

					$("#patientId").append(html);

				}

			});
		} else {

			alert("please Select DoctorId");
		}
	}

	function getInsuranceByPatientId() {
		var patientId = $("#patientId").val();
		alert(patientId);

		if (patientId != "0") {

			$
					.ajax({
						type : "POST",
						url : "./getInsuranceByPatientId",
						data : {
							patientId : patientId

						},
						success : function(response) {
							//alert(resoponse);
							console.log(response);
							var insuranceName = response.insuranceSchemeID.insuranceId.insuranceName;
							var insuranceSchemeName = response.insuranceSchemeID.insuranceSchemeName;

							console.log(insuranceName);
							console.log(insuranceSchemeName);
							$("#insSchemeName").html(insuranceSchemeName);
							$("#insName").html(insuranceName);
						}

					});

		}

	}

	function validate()
	{
		debugger;
		var doctorId = $("#doctorId").val();
		var hospitalId = $("#hospitalId").val();
		var patientId = $("#patientId").val();
		var addId = $("#addId").val();
		var disId = $("#disId").val();
		var expensesId = $("#expensesId").val();
		var today=new Date();

		if(hospitalId == "0")
		   {

	           alert("Select hospitalId");
	           return false;

				}
		if(doctorId == "0")
	   {

           alert("Select doctorId");
           return false;

			}
		
		if(patientId == "0")
		   {

	           alert("Select patientId");
	           return false;

				}
		if(addId == "")
		   {

	           alert("Select addId");
	           return false;

		 }
		if(disId == "")
		   {

	           alert("Select disId");
	           return false;

		  }
		if(expensesId == "")
		   {

	           alert("Select expensesId");
	           return false;

		  }
              alert("ok")

              return true;
	}
</script>
</html>