# debug: result usage steps

[when]activity '{activity}' for request=$activity:{activity}( request == $request )
[when]activity '{activity}'=$activity:{activity}(  )
[when]activity succeeded=exists ActivitySucceeded( activity == $activity )
[when]request '{request}'=$request:{request}(  )
[when]request inputs \(=(or
[when]input '{type}'=$input : {type}( request == $request ) 

[when]subrequest '{subrequest}'=$subrequest : {subrequest}(parentActivity == $activity)
[when]subrequest succeeded=$subrequestStatus : RequestStatus( request == $subrequest, succeeded == true )
[when]subrequest failed=$subrequestStatus : RequestStatus( request == $subrequest, succeeded == false )
[when]subrequest outputs \(=(or
[when]subrequest output '{type}'=$output : {type}( request == $subrequest ) 

[then]add subrequest '{type}'={type} r = new {type}(); r.setParentActivity($activity); insert(r);
[then]add subrequest parameter '{param}' as '{type}'=insert(new {type}(r, {param}));

[then]add activity fact from request input=insert( $input.cloneArtifact($activity) );
[then]add activity fact from request output=insert( $output.cloneArtifact($activity) );

[then]activity succeeded=insertLogical( new GenericActivitySucceeded($activity) );
[then]set request status succeeded=RequestStatus requestStatus = new RequestStatus($request, "ok", true); insert(requestStatus);
[then]set activity failed with status \"{status}\"=insert( new GenericActivityError($activity, "{status}") );
[then]add request status parameter {param} as {type}=insert( new {type}({param}, {param}.getName(), null, requestStatus));