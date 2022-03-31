import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';
// import router from './router';


Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        id: null,
        auth: null,
    },

    plugins: [
        createPersistedState({ 
            paths: ["id","auth"] 
        })
    ],

    mutations: {
        loginData: function(state, payload) {
            state.id = payload.id;
            state.auth = payload.auth;
        },

        logout(state) {
            state.id = null
            state.auth = null
        },
    },

    actions: {
        logout(context) {
            context.commit('logout');
        }
    }
})

export default store;