<%-- 
    Document   : Test4
    Created on : Jun 19, 2023, 8:02:15 AM
    Author     : Kim Khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Users" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UserControl" method="POST" style="margin:auto">
        <%
           
            ArrayList<Users> data=new ArrayList<Users>();
            if(request.getAttribute("data") != null)
                data =(ArrayList<Users>)request.getAttribute("data");
        %>
        List Users:
        <table border="1">
            <tr>
                <td>  Account    </td>
                <td>  Password   </td>
                <td>  Name       </td>
                <td>  Gender     </td>
                <td>  Address    </td>
                <td>  Dob </td>
            </tr>
            <%
              for(Users u : data )
              {
                 out.print("<tr>");
                 out.print("<td>"+u.getAccount()+"</td>");
                 out.print("<td>"+u.getPassword()+"</td>");
                 out.print("<td>"+u.getName()+"</td>");
                 out.print("<td>"+u.getGender()+"</td>");
                 out.print("<td>"+u.getAddress()+"</td>");
                 out.print("<td>"+u.getDob()+"</td>");
                 out.print("</tr>");
              }
            
            %>
        

        </table>
            </form>
    </body>
</html>
