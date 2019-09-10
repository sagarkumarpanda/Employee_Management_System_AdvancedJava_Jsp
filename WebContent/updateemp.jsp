<jsp:include page="header.jsp"/>
 <h3 class="center-align"> Update Employee</h3>
	
  <div class="container" style="border:2px;padding:5%">
    <form class="col s12" action="UpdateEmployee" method="post">
     
     
     <div class="row">
        <div class="input-field col s12">
          <input placeholder="Enter your name" name="empId" type="text" class="validate" id="empName" value='${emp.empId}' hidden>
         
        </div>
       </div>
     
     
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="Enter your name" name="empName" type="text" class="validate" id="empName" value='${emp.empName}'>
          <label for="first_name">Name</label>
          <span>
        	<h4 id="error-msg-name"></h4>
          </span>
        </div>
       </div>
     
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="DD/MM/YYYY" name="dob" type="text" class="validate" value="${emp.DOB}">
          <label for="password">DOB</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="Enter Basic Salary" name="basicSal" type="number" class="validate" value="${emp.basicSalary}">
          <label for="email">Salary</label>
        </div>
      </div>
      <input class="waves-effect waves-light btn" type="submit"></input>
    
     
     
     
     
  </div>
<jsp:include page="footer.jsp"/>