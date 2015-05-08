<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>Toets</title>
		<link href="css.css" rel="stylesheet">
	</head>
	<body>
		<div class="body">
			<div class="header">
				<h1>Header</h2>
			</div>
			<div class="content">
				<h2>${vraagnummer}</h2>
				<div class="vraag+context">
				<p id="context">${context }</p>
				<p id="vraagstelling">${vraag }</p>
				</div>
				<div class="ilustratie">
				</div>
				<div class="antwoord">
					<form id="antwoord">
						<input type="text" name="antwoord" placeholder="Voer hier uw antwoord">
						<button type="submit" name="rekenmachine" value="toon">rekenmachine</button>
						<button type="submit" name="volgendeVraag" value="volgende">volgende</button>
					</form>
				</div>
			</div>
			<div class="footer">
				<h6>©Footer</h6>
			</div>
		</div>
	</body>
</html>