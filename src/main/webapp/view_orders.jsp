<%@page import="java.util.ArrayList"%>
<%@page import="Data.Orders"%>
<%@page import="Data.User"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">

        <% HttpSession session1 = request.getSession();
            ArrayList<Orders> myOrders = (ArrayList<Orders>) session1.getAttribute("myOrders");

        %>
        <title></title>
    </head>
    <body>
        <main class="container-fluid" style="padding: 0;">
            <!--side 2 start-->
            <section class="frontpage" id="se_page">
                <div id="navbar">
                    <a href="shop.jsp">Shop</a>
                    <a href="#th_page">third page</a>
                </div>
                <div class="col-md-8 shop">
                    <h1>My previous orders</h1>
                    <form action="Controller?origin=viewBricks" method="post">
                        <input type="number" name="viewBricksID" min="3" value="3" required>
                        <input class="btn btn-primary" type="submit" value="View bricks"><br><br>
                    </form>
                    <table class="col-md-12">
                        <tr>
                            <th>Order ID</th>
                            <th>Width</th>
                            <th>Length</th>
                            <th>Height</th>
                            <th>Bandtype</th>
                            <th>IsShipped</th>
                            <th>Email</th>
                        </tr>
                        <% for (int i = 0; i < myOrders.size(); i++) { %>
                        <tr>
                            <td><% out.print(myOrders.get(i).getOrderID()); %></td>
                            <td><% out.print(myOrders.get(i).getWidth()); %></td>
                            <td><% out.print(myOrders.get(i).getLength()); %></td>
                            <td><% out.print(myOrders.get(i).getHeight()); %></td>
                            <td><% out.print(myOrders.get(i).getBandType()); %></td>
                            <td><% out.print(myOrders.get(i).isIsShipped()); %></td>
                            <td><% out.print(myOrders.get(i).getEmail()); %></td>
                        </tr>
                        <%
                            }
                        %>
                </div>
            </section>
            <!--side 2 slut-->
        </main>
    </body>
</html>
