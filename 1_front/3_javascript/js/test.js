//함수 test 생성
function test() {
  window.alert('외부 작성 방식!');
}
//window.onload = () => {
//  alert('윈도우 로딩 후!!!');
//};

window.onload = function () {
  alert('윈도우 로딩 후!!!');
};
