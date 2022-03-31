import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueMoment from 'vue-moment'
import router from './router';
import store from './store';

Vue.use(VueMoment);
Vue.use(ElementUI);
// Vue.use(store);


Vue.config.productionTip = false

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app')
