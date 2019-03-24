<%@page import="Data.User"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <%
            HttpSession session1 = request.getSession();
            int[] brickList = (int[]) session1.getAttribute("viewBricksList");
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
                    <a class="btn log btn-primary" href="Controller?origin=myOrders" style="float:right;">View order</a>
                </div>
                <div class="col-md-8 shop">
                    <h1>Information regarding your brick list</h1>
                    <table class="col-md-12">
                        <tr>
                            <th>Side 1 & 3</th>
                            <th>Bricks</th>
                        </tr>
                        <form action="Controller?origin=calBricks" method="post">
                            <tr>
                                <td class="col-md-2">Bricks 4X</td>
                                <td class="col-md-2"><% out.print(brickList[0]); %></td>
                            </tr>
                            <tr>
                                <td class="col-md-2">Bricks 2X</td>
                                <td class="col-md-2"><% out.print(brickList[1]); %></td>
                            </tr>
                            <tr>
                                <td class="col-md-2">Bricks 1X</td>
                                <td class="col-md-2"><% out.print(brickList[2]);%></td>
                            </tr>
                            <tr>
                                <th>Side 2 & 4</th>
                                <th>Bricks</th>
                            </tr>
                            <tr>
                                <td class="col-md-2">Bricks 4X</td>
                                <td class="col-md-2"><% out.print(brickList[3]); %></td>
                            </tr>
                            <tr>
                                <td class="col-md-2">Bricks 2X</td>
                                <td class="col-md-2"><% out.print(brickList[4]); %></td>
                            </tr>
                            <tr>
                                <td class="col-md-2">Bricks 1X</td>
                                <td class="col-md-2"><% out.print(brickList[5]);%></td>
                            </tr>
                    </table>
                </div>
            </section>
            <!--side 2 slut-->
        </main>
    </body>
</html>
