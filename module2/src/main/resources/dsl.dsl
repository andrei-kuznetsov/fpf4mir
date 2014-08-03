# debug: result usage steps

[when]activity '{activity}' for request=$activity:{activity}( request == $request )

[when]activity for request=$activity:Activity( request == $request )

[when]any activity request=$request: ReqNewActivity(  )
[when]any activity '{type}'=$activity: {type}(  )
[when]any activity=$activity: Activity(  )
[when]any '{type}\({whatever}\)'={type}({whatever})
[when]any '{type}'={type}(  )

[when]active activity '{activity}'=$activity:{activity}(  ) and ALCWork( activity == $activity )
[when]analyze activity '{activity}'=$activity:{activity}(  ) and ALCAnalyze( activity == $activity )

[when]request '{request}'=$request:{request}(  )
[when]request inputs \(=(or
[when]input '{type}'=$input : {type}( request == $request ) 

[when]subrequest for activity=subrequest 'ReqNewActivity' for activity
[when]subrequest '{subrequest}' for activity=$subrequest : {subrequest}(parentActivity == $activity)
[when]subrequest {subrequest:\w+} for activity=$subrequest : {subrequest}(parentActivity == $activity)
#[when]- has name=name != null
[when]subrequest completed=RLCCompleted( request == $subrequest )
[when]subrequest succeeded=$subrequestStatus : GenericRequestSucceeded( request == $subrequest ) and RLCCompleted( request == $subrequest )
[when]subrequest failed=$subrequestStatus : GenericRequestFailed( request == $subrequest ) and RLCCompleted( request == $subrequest )
[when]subrequest outputs \(=(or
[when]subrequest output '{type}'=$output : {type}( rstatus == $subrequestStatus ) 

[when]cmd options for activity=$options : java.util.LinkedList() from collect ( OrdinalArgument( activity == $activity ) )
[when]exec command succeeded=ExecStatus( activity == $activity, succeeded == true )

[when]'{type}' for activity=$artifact : {type}(activity == $activity)
[when]{type:\w+} for activity={type}(activity == $activity)
[when]{type:\w+}\({whatever}\) for activity={type}(activity == $activity, {whatever})
[when]{type:\w+} for request={type}(request == $request)
[when]{type:\w+}\({whatever}\) for subrequest={type}(request == $subrequest, {whatever})
[when]{type:\w+} for subrequest='{type}' for subrequest
[when]'{type}' for subrequest={type}(request == $subrequest)

[then]log {message}=System.out.println({message});
[then]def user action {type:\w+}={type} useraction = new {type}(); useraction.setActivity($activity);
[then]add user action attr {attr:\w+} as {value}=useraction.set{attr}({value});
[then]add user action=insert(useraction);
[then]add feature action '{feature}' version '{version}';=insert( new GenericAddFeatureAction($activity, "{feature}", "{version}") );
[then]add feature action '{feature}';=insert( new GenericAddFeatureAction($activity, "{feature}") );
[then]error '{err}' fixed=insert( new GenericActivityErrorFixed({err}) );

[then]add subrequest '{type}' with refId '{refId}';={type} $subrequest = new {type}(); $subrequest.setParentActivity($activity); $subrequest.setRefId({refId}); insert($subrequest);
[then]add subrequest '{type}'={type} $subrequest = new {type}(); $subrequest.setParentActivity($activity); insert($subrequest);

[then]add subrequest parameter '{param}' with name "{name}";=add subrequest parameter '{param}' with name '"{name}"';
[then]add subrequest parameter '{param}' with name '{name}';=\{GenericAlias o = new GenericAlias(); o.reset($subrequest, {name}, {param}); insert(o);\}

[then]add subrequest parameter '{param}' as '{type}'=\{{type} o = new {type}(); o.reset($subrequest, {param}); insert(o);\}
[then]add subrequest parameter '{param}'=\{GenericAlias o = new GenericAlias(); o.reset($subrequest, {param}); insert(o);\}


[then]add activity fact from alias '{alias}'=insert( {alias}.cloneRefObject($activity) );
[then]add activity fact from request input=insert( $input.cloneRefObject($activity) );
[then]add activity fact from request output=insertLogical( $output.cloneRefObject($activity) );
[then]add activity fact from alias '{alias}';=insert( {alias}.cloneRefObject($activity) );
[then]add logical activity fact from alias '{alias}';=insertLogical( {alias}.cloneRefObject($activity) );

[then]add ordinal {order} {value}=insertLogical( new OrdinalArgument( $activity, {order}, {value}) );
[then]execute command {cmd} in working dir {wd}=insertLogical( new ListExecCommand($activity, {cmd}, {wd}, $options) );

[then]activity succeeded=GenericActivityResultSucceeded activityStatus=new GenericActivityResultSucceeded($activity); insert(activityStatus);
[then]activity failed with status {status}=insert( new GenericActivityResultFailed($activity, {status}) );
[then]activity failed with message {status}=insert( new GenericActivityResultFailed($activity, {status}) );
[then]request succeeded=RequestFinalStatus requestStatus = new GenericRequestSucceeded($request, "ok"); insert(requestStatus);
[then]subrequest succeeded=RequestFinalStatus subrequestStatus = new GenericRequestSucceeded($subrequest, "ok"); insert(subrequestStatus);

[then]add {type:\w+} as request status=add request status parameter $artifact as Generic{type}Alias


[then]add activity status parameter '{param}' with name "{name}";=add alias 'activityStatus' '{param}'  '"{name}"';
[then]add activity status parameter '{param}' with name '{name}';=add alias 'activityStatus' '{param}'  '{name}';

[then]add alias '{subj}' '{obj}' '{name}';=\{GenericAlias o = new GenericAlias(); o.reset({subj}, {name}, {obj}); insert(o);\}


[then]add request status parameter {param} as {type}=add parameter '{param}' to 'requestStatus' as {type};
[then]add activity status parameter '{param}';=add activity status parameter {param} as GenericAlias
[then]add activity status parameter {param} as {type}=add parameter '{param}' to 'activityStatus' as {type};

[then]insert artifact '{value}' as '{type}'=\{{type} o = new {type}(); o.reset($activity, {value}); insert(o);\};
#[then]insert '{value}' as '{type}';=\{{type} o = new {type}(); o.reset($activity, {value}); insert(o);\};

[then]insert '{value}' as candidate '{type}';=\{{type} oo = new {type}(); oo.reset($activity, {value}); {type}Candidate o = new {type}Candidate(); o.reset($activity, oo); !!!appender!!!; 

[then]insert '{value}' as '{type}'=\{{type} o = new {type}(); o.reset($activity, {value}); !!!appender!!! 
[then]!!!appender!!! with name "{name}"=!!!appender!!! with name '"{name}"'
[then]!!!appender!!! with name '{name}'=o.setName({name}); !!!appender!!!
[then]!!!appender!!! ;=!!!appender!!!;
[then]!!!appender!!!;=insert(o);\};

[then]insert '{value}' as new '{type:\w+}';=insert( new {type}($activity, {value}) );
[then]insertLogical '{value}' as '{type}';=\{{type} o = new {type}(); o.reset($activity, {value}); insertLogical(o);\};

[then]insertLogical '{value}' as '{type}' for request;=\{{type} o = new {type}(); o.reset($request, {value}); insertLogical(o);\};

[then]insert {type:\w+} for request;=\{{type} o = new {type}(); o.setRequest($request); insert(o);\};
[then]insert {type:\w+}=\{{type} o = new {type}(); o.setActivity($activity); insert(o);\};
[then]insertLogical {type:\w+}=\{{type} o = new {type}(); o.setActivity($activity); insertLogical(o);\};

[then]add parameter '{param}' to '{status}';=add parameter '{param}' to '{status}' as GenericAlias;
[then]add logical parameter '{param}' to '{status}';=add logical parameter '{param}' to '{status}' as GenericAlias;

[then]add parameter '{param}' to '{status}' as {type};=\{{type} o = new {type}(); o.reset({status}, {param}); insert(o);\};
[then]add logical parameter '{param}' to '{status}' as {type};=\{{type} o = new {type}(); o.reset({status}, {param}); insertLogical(o);\};

