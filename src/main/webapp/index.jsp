<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title></title>
  </head>

  <form class="" action="index.html" method="post">
    
  </form>
  <body>
    <main class="container-fluid">
      <!--frontpage start-->
      <section class="row login_form clearfix">
        <div class="col-md-6 side1">
        </div>
        <!--login form start-->
        <div class="col-md-6 side2">
        <h1>Welcome</h1>
        <div class="side2_form col-md-6">
            <form class="login_form" action="Controller?origin=checkLogin" method="post">
                  <h1>Login</h1>
                    <div class="form-group col-md-12">
                      <input type="email" name="email" class="form-control" placeholder="Enter email" required>
                    </div>
                    <div class="form-group col-md-12">
                      <input type="password" name="password" class="form-control" placeholder="Password" required>
                    </div>
                <button type="submit" class="btn btn-primary col-md-12">Login</button>
              </form>
          <small>If youre not registered, click here</small>
          <button class="btn btn-primary col-md-12" onclick="openForm()">Register</button>
          <!--login form slut-->
      </div>
              <!--Opret bruger formen start-->
                  <div class="form-popup side2_form col-md-6" id="myForm">
                    <form action="Controller?origin=makeCustomer" class="form-container" method="post">
                      <h1>Register</h1>

                      <div class="form-group col-md-12">
                      <input type="email" name="email" class="form-control" placeholder="Enter email">
                      </div>

                      <div class="form-group col-md-12">
                        <input type="password" name="password" class="form-control" placeholder="Password">
                      </div>

                      <button type="submit" class="btn btn-primary">Create</button>
                      <button type="button" class="btn cancel btn-primary" onclick="closeForm()">Close</button>
                    </form>
                  </div>
              <!--Opret bruger formen slut-->
        </div>
      </section>
<!--frontpage slut-->
<!--side 3 start-->
      <section class="row third_page" id="th_page">
<a href="#">top</a>
      </section>
<!--side 3 slut-->
    </main>
  </body>
  <script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}

window.onscroll = function() {myFunction()};

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
