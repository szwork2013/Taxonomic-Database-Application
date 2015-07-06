var http = require('http');
var express = require('express');
var app = express();
var path    = require("path");

//app.use(express.json());
//app.use(express.urlencoded());
app.use(express.static(__dirname + '/../'));

app.set('port', process.env.PORT || 9000);

http.createServer(app).listen(app.get('port'), function(){
    console.log('Express server listening on port ' + app.get('port'));
});
