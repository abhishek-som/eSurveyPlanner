<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="shortcut icon" href="resources/ico/favicon.ico">

		<title>eSurveyPlanner</title>

		<!-- Bootstrap core CSS -->
		<link href="resources/css/bootstrap.min.css" rel="stylesheet">
		<!-- Bootstrap theme -->
		<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">

		<!-- Just for debugging purposes. Don't actually copy this line! -->
		<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

		 <!--  script src="resources/js/utility.js"></script>-->
		
		<script>
			
			var ansCount=0;	
		
			function addDynamicRow(){
				
				if (ansCount>=10){
					alert("Sorry! You can add maximum of 10 answers!");
						
				} else {
					var table = document.getElementById("answerTable");
					
					var answerValue = document.getElementById("answer").value;
					var row = table.insertRow(table.rows.length);	
					row.id = "answer"+table.rows.length;
					row.class="";
					
					var rowId=row.id;
					
					var cell1 = row.insertCell(0);
					//cell1.innerHTML = rowId+": "+answerValue+"<input type='hidden' name ='ansDesc"+ansCount+"' value='"+answerValue+"'>";
					cell1.innerHTML = rowId+": "+answerValue+"<input type='hidden' name ='ansTextList["+ansCount+"]' value='"+answerValue+"'>";
					
					
					var cell2 = row.insertCell(1);
					cell2.innerHTML = "<button type='button' class='btn btn-default' onclick='deleteDynamic("+rowId+")'>Delete</button>";
					
					document.getElementById("answer").value="" ;
					ansCount +=1;
								
				}
					
			}
			
			function deleteDynamic(rowId){
				rowId.remove();
				ansCount -=1;
			}
		</script>

		<link href="resources/css/datepicker.css" rel="stylesheet">

		<link href="resources/css/bootstrapValidator.css" rel="stylesheet">
		
		<link href="resources/css/master.css" rel="stylesheet">
	</head>

	<body role="document">

		<%@include file="includes/header.jsp" %>

			<div class="row form-div-cus">
				<div class="col-sm-4">
					<div class="well">
						<p>
							<h2><span class="glyphicon glyphicon-user"></span> Hi, Admin! ${surveyDTO.surveyName}</h2>
						</p>
						Give the answer type for each question.
					</div>
				</div>
				<div class="col-sm-8" style="border:1px solid #d9d9d9; padding:1em; border-radius:4px;">
					<form action="addQuestions" method="POST">
                                            
                        <input type="hidden" name="surveyId" value='${surveyDTO.surveyId}'>
					    <input type="hidden" name="surveyName" value='${surveyDTO.surveyName}'>
                                            
						<div class="output">
							<label for="surveyname">${surveyDTO.surveyName}</label>
							
						</div>
						<div class="form-group">
							<label for="">Type of Answer - </label>
                                                        <c:forEach var="answerTypeMaster" items="${answerTypeMaster}">
                                                            <input type="radio"  name="ansTypeID" value="${answerTypeMaster.id}"/>${answerTypeMaster.ansTypeText}
                                                            
                                                        </c:forEach>
                                                       
						</div>
						
						<div class="form-group">
							<label for="surveyname">Answers: </label>
							
								<input type="text" class="form-control" name="answer[]" id="answer" placeholder="Answers"/>
								
								<button type="button" class="btn btn-default" onclick="addDynamicRow()">Add</button>
								<!--  button type="button" class="btn btn-default">Delete</button-->
								<table id="answerTable" class="table table-striped"></table>						
								
							
						</div>

						<div class="form-group">
							<div>
								<button type="submit" class="btn btn-primary">Proceed</button>
							</div>
						</div>						
						
						
						
					</form>
				</div>
			</div>

		<%@include file="includes/footer.jsp" %>

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/bootstrap-datepicker.js"></script>
		<script src="resources/js/bootstrapValidator.js"></script>
		<script src="resources/js/utility.js"></script>
	</body>
</html>

