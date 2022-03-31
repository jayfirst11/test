<template>
  <div id="mainboard">
    <!-- <router-view /> -->
    <el-button type="danger" @click="openRegistPopup()">글쓰기</el-button>
    <regist-board @reload="reload" ref="registPopup"></regist-board>
    <board-list ref="list"></board-list>
  </div>
</template>

<script>
import RegistBoard from '@/components/RegistBoard.vue';
import BoardList from '@/components/BoardList.vue';
// import MainPage from './components/MainPage.vue';

export default {
  name: 'MainPage',
  components: {
    RegistBoard,
    BoardList,
    // MainPage,
  },
  methods: {
    reload() {
      this.$refs.list.getBoardList();
    },
    openRegistPopup() {
      this.$refs.registPopup.openPopup = true;
    },
    toLogin() {

    }
  },
};
</script>

<style></style>
