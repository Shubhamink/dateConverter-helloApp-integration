<html>

<head>
    <link href="css/style.css" rel="stylesheet"></head>
    <title> Web Application</title>
</head>

<body >
<div class="welcome">
<h1 >
    Hello, ${name}!
</h1>
<h2>
    UTC TimeZone: Date - ${utc_date} <br>
    London TimeZone: Date - ${london_date}<br>
    IST TimeZone: Date - ${ist_date}<br>
    NY TimeZone: Date - ${ny_date}
</h2>
 <div> <input type="button" value="Go Back" onclick="history.go(-1);"> </div>
</div>
</body>

</html>