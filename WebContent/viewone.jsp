<jsp:include page="header.jsp"/>
 <h3 class="center-align"> Get Employee</h3>
	
  <div class="container" style="border:2px;padding:5%">
    <form class="col s12" action="GetEmployee" method="post">
      <div class="row">
        <div class="input-field col s12">
          <input placeholder="Enter Employee ID" name="empId" type="text" class="validate">
          <label for="first_name">Employee ID</label>
        </div>
       </div>
     
      <input class="waves-effect waves-light btn" type="submit"></input>
    </form>
  </div>
<jsp:include page="footer.jsp"/>