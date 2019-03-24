<%@page import="Data.User"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <%
            HttpSession session1 = request.getSession();
            User u = (User) session1.getAttribute("user");
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
                    <h1>Fill out the form to place an order</h1>
                    <table class="col-md-12">
                        <tr>
                            <th class="col-md-2">Width</th>
                            <th>Length</th>
                            <th>Height</th>
                            <th>Bandtype</th>
                        </tr>
                        <form action="Controller?origin=calBricks" method="post">
                            <tr>
                                <td class="col-md-2"><input type="number" min="0" name="Width" placeholder="0"></td>
                                <td class="col-md-2"><input type="number" min="0" name="Length" placeholder="0"></td>
                                <td class="col-md-2"><input type="number" min="0" name="Height" placeholder="0"></td>
                                <td class="col-md-2">
                                    <input type="radio" name="Band" value="1" checked> ½-stensforbandt<br>
                                    <input type="radio" name="Band" value="2"> 1/4-stensforbandt<br>
                                    <input type="radio" name="Band" value="3"> Blok forbandt<br>
                                    <input type="radio" name="Band" value="4"> Kryds forbandt<br>
                                    <input type="radio" name="Band" value="5"> Engelsk forbandt
                                </td>    
                            </tr>
                    </table>
                    <button type="submit" class="btn log btn-primary" name="submit">Calculate bricks</button> 
                    </form>
                </div>
            </section>
            <!--side 2 slut-->
        </main>
    </body>
</html>
