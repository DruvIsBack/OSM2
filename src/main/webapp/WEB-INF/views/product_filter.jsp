<!DOCTYPE html>
<html>
	<head>
    	<title>My Site</title>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
	<body style="font-family:'Roboto Condensed', 'Gill Sans MT', 'Century Gothic', Arial, 'Bell MT'">
    	<div class="container">
        	<div style="text-align: right; margin-bottom:5px;">
            	<button class="btn-link">Register or Login Here</button>
                  <div class="dropdown" style="text-align:left">
                      <button class="dropbtn">Hi, Anirban Sanyal <span class="glyphicon glyphicon-triangle-bottom"></span></button>
                      <div class="dropdown-content">
                        <a href="#">My Account</a>
                        <a href="#">My Orders</a>
                      </div>
                </div>
                <button class="btn" style="padding:0px 10px;">Logout</button>
            </div>
            <div class="my_header">
                <div id="title">
                	<span class="glyphicon glyphicon-shopping-cart"></span>
                    Online Shoping Site
                	<div id="sub_title">Its time to move on</div>
                </div>
            </div>
            <div class="my_path">
            	<button class="btn btn-primary">Homepage</button>
                <span class="glyphicon glyphicon-arrow-right"></span>
                <button class="btn btn-primary">Smartphone And Tablets</button>
            </div>
            <div class="container-fluid">
            <div class="row">
            	<div class="col-md-3" style="background-color: #E1B0B0; padding: 10px; font-size: large; text-shadow: 1px 1px 2px #878787;">
                	<div align="center" class="my_filter_module">
                    	<div>
                        	Price Min (INR.) <br>
                        	<input type="number"/>
                        </div>
                        <div>
                        	Price Max (INR.) <br>
                        	<input type="number"/>
                        </div>
                        <div>
                        	Product Vendor <br>
                        	<select>
                            	<option selected>All</option>
                            	<option>Nokia</option>
                                <option>Samsung</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-md-9" style="padding-top: 10px; padding-right: 5px; padding-left: 10px; padding-bottom: 15px;">
                	<div class="my_item">
                    	<div id="pic" class="img-thumbnail carousel-inner">
                        	<img src="images/product_images/xiaomi redmi note 3.jpg"/>
                            <div class="carousel-caption" id="pic_caption">5600.00 /-</div>
                        </div>
                        <div id="text">Xiaomi Redmi Note 3</div>
                    </div>
                    <div class="my_item">
                    	<div id="pic" class="img-thumbnail carousel-inner">
                        	<img src="images/product_images/ZTE Axon 7 Max.jpg"/>
                            <div class="carousel-caption" id="pic_caption">7200.00 /-</div>
                        </div>
                        <div id="text">ZTE Axon 7 Max</div>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </body>
</html>