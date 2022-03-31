<template>
  <div id="app">
    <div style="text-align:right;">

      <div v-if="$store.state.auth != null">
        <span v-bind="roleAuth()">{{someone}}({{$store.state.id}}){{ending}}</span>
      </div>

      <div v-if="this.$route.name != 'Home'">
        <router-link to="/"
          tag="button">게시판</router-link>
      </div>

      <div v-else>
        <router-link to="/login"
          v-if="$store.state.id == null"
          tag="button">로그인</router-link>

        <button @click="logoutCheck()"
          v-if="$store.state.id != null">
          로그아웃</button>
      </div>

    </div>
    <p>{{$store.state.id}}</p>
      <router-view />
  </div>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      someone: '',
      ending: '',
    }
  },
  methods: {
    roleAuth() {
      if(this.$store.state.auth == 'admin') {
        this.someone = '관리자'
        this.ending = '로 로그인 하였습니다.'
      } else {
        this.someone = '회원'
        this.ending = '으로 로그인 하였습니다.'
      }
    },
    logoutCheck() {
      // this.$store.auth = ''
      // this.$store.id = ''
      console.log("auth::", this.$store.auth);
      console.log("id::", this.$store.id);
      this.$store.dispatch('logout');
      // location.reload();
    },
    
  }

};
</script>

<style></style>
