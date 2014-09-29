<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Automatic Deployment Service for CLI Apps</title>
</head>
<body>
	<h1>Hello World!</h1>

	<form id="file-form" action="/kb/deploy" method="POST" enctype="multipart/form-data">
		<input type="file" id="file-select" name="originalArtifact" />
		<button type="submit" id="upload-button">Upload</button>
	</form>

	<hr>
	
	<form id="file-form" action="/kb/deployref" method="POST" enctype="multipart/form-data">
		<input type="text" id="file-select" name="magic" />
		<button type="submit" id="dir-button">Submit local</button>
	</form>
	
</body>
</html>