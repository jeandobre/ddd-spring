const resources = ['https://cdn.jsdelivr.net/npm/vuetify@2.x/dist/vuetify.js', 
'https://cdn.jsdelivr.net/npm/vue@2.x/dist/vue.js'];

var firstScript = document.getElementsByTagName('script')[0];

resources.forEach(link => {
	var js = document.createElement('script');
	js.src = link;
	firstScript.parentNode.insertBefore(js, firstScript);
});
 
function init() {
	new Vue({
      el: '#app',
      vuetify: new Vuetify({}),
    });
}