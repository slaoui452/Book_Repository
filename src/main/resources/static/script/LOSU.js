function Signup() {
  document.getElementById('id02').style.display='block';
  document.getElementById('id03').style.display='block';
  document.getElementById('id04').style.display='none';
  document.getElementById('euL').style.display='none';
  document.getElementById('id09').style.display='none';
    document.getElementById('id030').style.display='none';

  document.getElementById('id020').style.display='none' ;
}
function Login() {
  document.getElementById('id02').style.display='none';
  document.getElementById('id03').style.display='none';
  document.getElementById('id09').style.display='block';
  document.getElementById('id04').style.display='block';
  document.getElementById('euL').style.display='block';
  document.getElementById('id020').style.display='none' ;
    document.getElementById('id030').style.display='none';

}
function Cancel() {
  document.getElementById('id01').style.display='none';
    document.getElementById('id030').style.display='none';

}
function Signup1() {
  document.getElementById('id01').style.display='block';
  document.getElementById('id02').style.display='block' ;
  document.getElementById('id03').style.display='block';
  document.getElementById('id020').style.display='none' ;
  document.getElementById('id04').style.display='none';
  document.getElementById('euL').style.display='none';
  document.getElementById('id09').style.display='none';
    document.getElementById('id030').style.display='none';

}

function Add_Adress() {
  document.getElementById('id01').style.display='block';
  document.getElementById('id030').style.display='none';
    document.getElementById('id02').style.display='none' ;
  document.getElementById('id020').style.display='block' ;
  document.getElementById('id03').style.display='none';
  document.getElementById('id04').style.display='none';
  document.getElementById('euL').style.display='none';
  document.getElementById('id09').style.display='none';
}

function Add_Book() {
  document.getElementById('id01').style.display='block';
  document.getElementById('id030').style.display='block';
    document.getElementById('id02').style.display='none' ;
  document.getElementById('id020').style.display='none' ;
  document.getElementById('id03').style.display='none';
  document.getElementById('id04').style.display='none';
  document.getElementById('euL').style.display='none';
  document.getElementById('id09').style.display='none';
}
function Login1() {
  turnAll("none");
  document.getElementById('Library').style.display = "block";
  document.getElementById('id01').style.display='block';
  document.getElementById('id02').style.display='none' ;
    document.getElementById('id030').style.display='none';
  document.getElementById('id03').style.display='none';
    document.getElementById('id020').style.display='none' ;
  document.getElementById('id04').style.display='block';
  document.getElementById('id09').style.display='block';
  document.getElementById('euL').style.display='block';
}
