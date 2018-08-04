import { setFlagsFromString } from 'v8';

var express = require('express');
var http = require('http');
var static = require('serve-static');
var bodyParser = require('body-parser');
var path = require('path');

var app = express();

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/test');

var db = mongoose.connection;

db.on('error', console.error);
db.once('open', function(){
    // CONNECTED TO MONGODB SERVER
    console.log("Connected to mongod server");
});

var userSchema = mongoose.Schema({
  user_id: String,
  user_pw: String,
  user_name: String,
  user_age: String,
  user_saying: String,
  user_major: String,
  user_sex: String,
  user_grade: String
});
var User = mongoose.model('User',userSchema);

//기본포트를 app 객체에 속성으로 설정
app.set('port', process.env.PORT || 3000);


//body-parser를 사용해 application/x-www-form-urlencoded 파싱
app.use(bodyParser.urlencoded({ extended: true }));

//body-parser를 사용해 application/json 파싱
app.use(bodyParser.json());

//app.use(static(path.join(__dirname, 'public')));
//app.use(express.static(path.join(__dirname, 'public')));
//app.set('view engine', 'jade')
//app.set('views', './views')


/*
app.get('/question', function (req, res) {
    Quest.find({}).sort({date:-1}).exec(function(err, rawContents){
      // db에서 날짜 순으로 데이터들을 가져옴
       if(err) throw err;
       res.render('question.jade', {title: "Board", contents: rawContents}); 
       // board.ejs의 title변수엔 “Board”를, contents변수엔 db 검색 결과 json 데이터를 저장해줌.
    });
});
*/
app.post('/question', function (req, res) {
    var title = req.body.title;
    var content = req.body.content;
    var quest = new Quest({title:title, content:content})
    quest.save(function(err){
      if (err) console.log(err);
      res.redirect('http://localhost:3000/question');
    });
});

//Express 서버 시작
http.createServer(app).listen(app.get('port'), function () {
    console.log('Express 서버를 시작했습니다. : ' + app.get('port'));
  });
