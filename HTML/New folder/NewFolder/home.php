
<html>
	<head>
		<title>Stadium Madness</title>
		<?php
			$files = array("themes/Orange.css", 
						   "themes/Black.css", 
						   "themes/Blue.css"
						   );
			$getRandom = array_rand($files, 1);
			<link rel="stylesheet" href="<?php echo $files[$getRandom]; ?>">
		?>
		<link rel="stylesheet" href="<?php echo $files[$getRandom]; ?>">
		<meta charset="UTF-8">
	</head>
	<body>
		<div id="header">
			<a href="#" ><img id="logo" src="html pics/stadiummadness.png" alt="Stadium Madness" id="logo"></a>
		</div>
		<div id="options">
			<a  class="button" onclick="textdisplay(0)">Server</a>
			<a  class="button" onclick="textdisplay(1)">Forums</a>
			<a  class="button" onclick="textdisplay(2)">IRC</a>
			<a  class="button" onclick="textdisplay(3)">Donate</a>
		</div>
		<footer><div id="footer">
		Copyright © Stadium Madness
		</div></footer>
		
	</body>
</html>