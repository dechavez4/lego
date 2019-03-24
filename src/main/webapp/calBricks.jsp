<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% HttpSession session1 = request.getSession();
            int[] bList = (int[]) session1.getAttribute("brickList");
        %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
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
                    <h1>Ordreliste</h1>
                </div>
                <div class="col-md-4 ordre">
                    <table class="col-md-6">
                        <tr> 
                            <th>SIDE 1 & 3</th>
                            <th>SIDE 2 & 4</th>
                        </tr>
                        <tr> 
                            <td><b>Bricks 4x</b></td>
                            <td><b>Bricks 4x</b></td>
                        </tr>
                        <tr>
                            <td><% out.print(bList[0]); %></td>
                            <td><% out.print(bList[3]); %></td>
                        </tr>
                        <tr>
                            <td><b>Bricks 2x</b></td>
                            <td><b>Bricks 2x</b></td>
                        </tr>
                        <tr>
                            <td><% out.print(bList[1]); %></td>
                            <td><% out.print(bList[4]); %></td>
                        </tr>
                        <tr>
                            <td><b>Bricks 1x</b></td>
                            <td><b>Bricks 1x</b></td>
                        </tr>
                        <tr> 
                            <td><% out.print(bList[2]);%></td>
                            <td><% out.print(bList[5]);%></td>
                        </tr>
                    </table>
                    <form action="Controller?origin=makeOrder" method="post">
                        <input class="" type="submit" value="Place order">                            
                    </form>
                </div>
            </section>
            <!--side 2 slut-->
        </main>
    </body>
    <script>
        var navbar = document.getElementById("navbar");
        var sticky = navbar.offsetTop;

        function myFunction() {
            if (window.pageYOffset >= sticky) {
                navbar.classList.add("sticky")
            } else {
                navbar.classList.remove("sticky");
            }
        }

    </script>
</html>
