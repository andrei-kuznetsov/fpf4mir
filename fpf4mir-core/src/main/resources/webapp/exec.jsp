<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Automatic Deployment Service for CLI Apps</title>
</head>
<body>
	<h1>Automatic Deployment Service for CLI Apps</h1>
	Please provide your application as a URL to any repository or as a single file and we'll do
	our best to deploy it to the cloud.<br><hr> 

	<form id="file-form" action="" method="POST" enctype="multipart/form-data">
		<input type="file" id="file-select" name="originalArtifact" />
		<button type="submit" id="upload-button">Upload file</button>
	</form>

	<hr>
	
	<form id="file-form" action="" method="POST" enctype="multipart/form-data">
		<input type="text" id="file-select" name="magic" />
		<button type="submit" id="dir-button">Submit URI</button>
	</form>
	
</body>
</html>