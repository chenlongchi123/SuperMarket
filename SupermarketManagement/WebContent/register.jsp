<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Responsive Register Template</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="Calendar.js"></script>
		<script language="javascript" type="text/javascript">		
		var c=new Calendar("c");
			document.write(c);
		function test(obj){
			with(obj){
			var idReg=/^\d{15}$|^\d{18}$|^\d{17}[xX]$/;
			
			if(!idcard.value.match(idReg)){
				alert("身份证号不合法");
				return false;
			}
			return true;
			}
		}
	
		</script>
		<script language="javascript" src="province.js" type="text/javascript" charset="gb2312"></script>

    </head>

    <body onload='getProvince()'>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">iApp Register <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="assets/img/iphone.png" alt="">
                </div>
                <div class="register span6">
				<form action="/SupermarketManagement/RegisterServlet" method=post name=form1>
					<h2>
						REGISTER TO <span class="red"><strong>iAPP</strong></span>
					</h2>
					<label for="sex">Sex</label>
					<table>
						<tr>
							<td><input type="radio" name="sex" value="1" />男</td>
							<td><input type="radio" name="sex" value="2" checked>女</input>
							</td>
						</tr>
					</table>
					<label for="name">Name</label> <input type="text" name="name" /><font
						color="red">${requestScope.errors.name}</font> <label
						for="password">Password</label> <input type="password"
						name="password" /><font color="red">${requestScope.errors.password}</font>
					<table><tr>证件类型：</tr>
					 <tr><select name="idtype">
						<option value="港澳通行证">港澳通行证</option>
						<option value="身份证" selected>身份证</option>
						<option value="护照">护照</option>
					</select></tr></table>
					<label for="card">Card</label> 
					<input type="text" name="idcard" /> <label for="email">Email</label>
					<input type="text" name="email" /> <label for="birthday">Birthday</label>
					<input type="text" name="birthday" onfocus="c.show(this)" /> <label
						for="postal">Postal</label> <input type="text" name="postal" />
					<table>
					<tr>
						<td>省份：</td>
						<td id='province'>请选择省份</td>
					</tr>
					<tr>
						<td>县/市：</td>
						<td id='city'><select><option>城市</option></select></td>
					</tr>
					</table>
					<button type="submit" value="ok">REGISTER</button>
				</form>
			</div>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>

