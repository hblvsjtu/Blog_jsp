
function proxy(str) {
	return str + '信息反馈';
}
onmessage=function (e) {
    postMessage(proxy(e.data));
}