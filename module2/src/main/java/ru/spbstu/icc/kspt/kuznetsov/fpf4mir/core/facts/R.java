package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class R {
	public static class id {
		// Artifacts
		public static final String OriginalArtifact = "OriginalArtifact";
		public static final String RunArtifact = "RunArtifact";
		public static final String TrainRunArtifact = "TrainRunArtifact";
		public static final String RegularRunArtifact = "RegularRunArtifact";
		

		public static final String BuildActivity = "BuildActivity";
		public static final String TestRunActivity = "TestRunActivity";
		public static final String DeployActivity = "DeployActivity";
		
		public static final String ExecBuild = "ExecBuild";
		public static final String ExecTestRun = "ExecTestRun";
		public static final String PomFiles = "PomFiles";
		
		public static final String DataDirRoot = "DataDirRoot";
		public static final String TmpDirRoot = "TmpDirRoot";

		public static final String RunData_FileList = "RunData_FileList";
		public static final String TestRunData_FileList = "TestRunData_FileList";
		public static final String TestRunResult_FileList = "TestRunResult_FileList";
		public static final String TestRunData = "TestRunData";
		public static final String TestRun_ResultDir = "TestRun_ResultDir";

		public static final String MvnRootPom = "MvnRootPom";
		
		public static final String RegularActivity = "RegularActivity";
		public static final String TestActivity = "TestActivity";
		
		public static final String MainDeployment = "MainDeployment";
		public static final String ExtractActivity = "ExtractActivity";
		public static final String UserActivity = "UserActivity";

		public static final String AnalyzeDeployFolderActivity = "AnalyzeDeployFolderActivity";
		
		public static final String GuessRunExecutableActivity = "GuessRunExecutableActivity";
		public static final String GuessRunCommandActivity = "GuessRunCommandActivity";
		
		public static final String GuessBuildSystemActivity = "GuessBuildSystemActivity";
		public static final String GuessBuildCommandActivity = "GuessBuildCommandActivity";
		public static final String DeployExecutableActivity = "DeployExecutableActivity";
	}

	public static class activity {
		public static final String GuessRunCommand = "GuessRunCommandActivity";
		public static final String GuessRunExecutable = "GuessRunExecutableActivity";
	}
	
	public static class artifact {

		public static final String main = "main";
		
	}

	public static class error {

		public static final String NoExecutableFound = "No executable found";
		public static final String TooManyExecutables = "Too many executables found";
		
	}
}
