<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<br><br><br>
<div class="container">
<table class="striped">
<thead>
          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>Date of Birth</th>
              <th>Basic Salary</th>
              <th colspan="2">Delete/Update</th>
          </tr>
        </thead>
  
    <tr>
      <td>${empl.empId}</td>
      <td>${empl.empName}</td>
      <td>${empl.DOB}</td>
      <td>${empl.basicSalary}</td>
      <td><a href='DeleteEmployee?empid=${empl.empId}'>Delete</a></td>
      <td><a href='updater?empId=${empl.empId}'>Update</a></td>
    </tr>

</table>
</div>

<jsp:include page="footer.jsp"/>