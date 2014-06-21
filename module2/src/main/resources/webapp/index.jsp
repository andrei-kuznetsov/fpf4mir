<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>

	<form id="file-form" action="/kb/deploy" method="POST" enctype="multipart/form-data">
		<input type="file" id="file-select" name="originalArtifact" />
		<button type="submit" id="upload-button">Upload</button>
	</form>

	<hr>

	<label for="build-type">Build type:</label>
	<select id="build-type" onchange="onBuildTypeChanged(this.value)">
	  <option value="none" selected>Not required</option>
	  <option value="auto">autodetect</option>
	  <option value="maven">maven</option>
	</select><br>
		
	<label for="run-type">Executable type:</label>
	<select id="run-type" onchange="onExecutableTypeChanged(this.value)">
	  <option value="auto" selected>autodetect</option>
	  <option value="java">Java</option>
	  <option value="python">Python</option>
	  <option value="matlab">MatLab</option>
	  <option value="linux">Linux (ELF)</option>
	  <option value="windows">Windows (PE)</option>
	</select><br>
	
	<label for="invocation-format">Invocation format:</label>
	<select id="invocation-format" onchange="onInvocationFormatChanged(this.value)">
	  <option value="mirex_chest">MIREX Audio Chord Estimation</option>
	  <option value="freeform">Freeform (fixed format)</option>
	  <option value="rest" selected>Freeform (REST interface)</option>
	</select><br>
	
	<form id="build-form-maven" action="handler.php" method="POST" style="visibility:hidden;" >
		<label for="maven-command">Maven command: $mvn</label>
		<input id="maven-command" name="maven-command" value="" type="text">
		<br>
		<button type="submit">Submit</button>
	</form>

	<form id="run-form-java" action="handler.php" method="POST" style="visibility:hidden;" >
		<label for="javavm-args">Java VM arguments: </label>
		<input id="javavm-args" name="javavm-args" value="" type="text">
		<br>
		<button type="submit">Submit</button>
	</form>
	
	<form id="invocation-form-freeform" action="handler.php" method="POST" style="visibility:hidden;" >
		<label for="invocation-command">Invocation arguments: </label>
		<input id="invocation-command" name="invocation-command" value="" type="text">
		<br>
		<button type="submit">Submit</button>
	</form>
	
	<script type="text/javascript" language="javascript">
		function onBuildTypeChanged(val){
			var formMaven = document.getElementById('build-form-maven');

			formMaven.style.visibility = 'hidden';
					
			if (val == 'maven'){
				formMaven.style.visibility = 'visible';
			}
		}
		
		function onExecutableTypeChanged(val){
			var formJava = document.getElementById('run-form-java');

			formJava.style.visibility = 'hidden';
					
			if (val == 'java'){
				formJava.style.visibility = 'visible';
			}
		}
		
		function onInvocationFormatChanged(val){
			var formFreeform = document.getElementById('invocation-form-freeform');

			formFreeform.style.visibility = 'hidden';
					
			if (val == 'freeform'){
				formFreeform.style.visibility = 'visible';
			}
		}
	</script>
	
</body>
</html>