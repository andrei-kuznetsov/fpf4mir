# debug: result usage steps

[when]activity '{activity}' for request=$activity:{activity}( request == $request )
[when]activity for request=$activity:Activity( request == $request )

[when]activity '{activity}'=$activity:{activity}(  ) and not ActivityStatus( activity == $activity ) and /*block for subrequest*/ forall( $subreq : RequestFact(parentActivity==$activity) \n RequestStatus(request==$subreq))

[when]activity succeeded=exists ActivitySucceeded( activity == $activity )
[when]request '{request}'=$request:{request}(  )
[when]request inputs \(=(or
[when]input '{type}'=$input : {type}( request == $request ) 

[when]subrequest '{subrequest}'=$subrequest : {subrequest}(parentActivity == $activity)
#[when]- has name=name != null
[when]subrequest succeeded=$subrequestStatus : RequestSucceeded( request == $subrequest )
[when]subrequest failed=$subrequestStatus : RequestFailed( request == $subrequest )
[when]subrequest outputs \(=(or
[when]subrequest output '{type}'=$output : {type}( rstatus == $subrequestStatus ) 

[when]cmd options for activity=$options : java.util.LinkedList() from collect ( OrdinalArgument( activity == $activity ) )
[when]exec command succeeded=ExecStatus( activity == $activity, succeeded == true )

[when]'{type}' for activity=$artifact : {type}(activity == $activity)
[when]{type:\w+} for activity={type}(activity == $activity)
[when]{type:\w+} for request={type}(request == $request)

[then]def user action {type:\w+}={type} useraction = new {type}(); useraction.setActivity($activity);
[then]add user action attr {attr:\w+} as {value}=useraction.set{attr}({value});
[then]add user action=insert(useraction);

[then]add subrequest '{type}'={type} r = new {type}(); r.setParentActivity($activity); insert(r);
[then]add subrequest parameter '{param}' as '{type}'=\{{type} o = new {type}(); o.reset(r, {param}); insert(o);\}

[then]add activity fact from request input=insert( $input.cloneRefObject($activity) );
[then]add activity fact from request output=insert( $output.cloneRefObject($activity) );

[then]add ordinal {order} {value}=insertLogical( new OrdinalArgument( $activity, {order}, {value}) );
[then]execute command "{cmd}" in working dir {wd}=insertLogical( new ListExecCommand($activity, "{cmd}", {wd}, $options) );

[then]activity succeeded=insert( new GenericActivitySucceeded($activity) );
[then]activity failed with status {status}=insert( new GenericActivityFailed($activity, {status}) );
[then]activity failed with type {type:\w+} and message {message}=insert( new GenericActivityFailed($activity, {type}, {message}) );
[then]set request status succeeded=RequestStatus requestStatus = new RequestSucceeded($request, "ok"); insert(requestStatus);

[then]add {type} as request status=add request status parameter $artifact as Generic{type}Alias
[then]add request status parameter {param} as {type}=\{{type} o = new {type}(); o.reset(requestStatus, {param}); insert(o);\};

[then]insert artifact '{value}' as '{type}'=\{{type} o = new {type}(); o.reset($activity, {value}); insert(o);\};
[then]cast activity '{value}' to '{type}'=\{retract({value}); {type} o = new {type}(); o.reset($activity); insert(o);\};