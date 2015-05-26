<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Student 1e keer</title>
<link href="css.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<img alt="" src="images/logo.png" style="margin: 10px;"></img>
	</div>
	<div class="content">
		<div class="links">
			<form action="enquete.do">
				<label>School</label><input type="text" name="school" required	placeholder="Bijvoorbeeld Cornelius"><br /> 
				<label>Lesjaar</label><input type="number" name="lesjaar" required placeholder="Bijvoorbeeld 5"><br />
				<Label>Profiel</label><input type="text" name="profiel" required placeholder="Bijvoorbeeld E&M"><br /> 
				<label>Niveau</label><input type="text" name="niveau" placeholder="Bijvoorbeeld HAVO"><br />
				<label>Geslacht</label> <input type="radio" name="geslacht"	value="man" checked>Man <input type="radio" name="geslacht"	value="vrouw">Vrouw<br /> 
				<label>Wiskunde cijfer</label><input type="number" name="gemWisCijfer" required placeholder="Bijvoorbeeld 7"><br /> 
				<label>Blijven zitten?</label><input type="date" name="blijvenZitten" required placeholder="Bijvoorbeeld 21-01-10"><br />		
				<input type="submit" name="button" value="next">		
			</form>
		</div>

	</div>
	<div class="footer">
		<center>
			<h6>© Direct-ACT & Justian Knobbout</h6>
		</center>
	</div>

</body>
</html>