<template>
    <div>
        <form>
            <label>ID</label>
            <input type="text" v-model="id">
            <label>PW</label>
            <input type="password" v-model="password">
            <button @click.prevent="loginSubmit()">login</button>
            <button @click.prevent="loginCancel()">돌아가기</button>
        </form>
        <div>
            <p>{{loginErr}}</p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'LoginPage',
    data() {
        return {
            id: '',
            password:'',
            auth:'',
            loginErr: "",
        }
    },

    methods: {
        loginSubmit() {

            const userData = {};
            userData.id = this.id;
            userData.password = this.password;
            
            axios
                .post("http://localhost:8080/login/get-login.do", userData, {
                    headers: {
                        // "Content-Type": `application/json`
                    }
                })
                .then((response) => {
                    if(response.data.success || response.data.result) {
                        console.log(response.data);
                        console.log(response.data.result.id);
                        console.log(response.data.result.auth);
                        this.$store.commit("loginData", response.data.result)
                        this.$router.push({name: 'Home'})
                    } else {
                        this.loginErr = "일치하는 회원이 없습니다."
                    }   
                })
                .catch(function(error){
                    console.log(error)
                });
        },

        loginCancel() {
            this.$router.push({
                name: 'Home'
            })
        }
    },
}
</script>