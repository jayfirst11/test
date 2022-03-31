import Vue from 'vue';
import VueRouter from 'vue-router';
import BoardComponent from './components/MainPage';
import LoginPage from './components/LoginPage';

Vue.use(VueRouter);

const route = [
    {path: "/", name: 'Home', component: BoardComponent},
    {path: "/login", name: 'Login', component: LoginPage},
]

//Vue 라우터 인스턴스 생성
const router = new VueRouter({
    mode: 'history',
    routes: route,
});

export default router;