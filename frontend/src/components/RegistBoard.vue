<template>
  <div>
    <el-dialog :title="ModalTitle" :visible.sync="openPopup" width="30%" center :close-on-click-modal="false">
      <el-input v-model="$store.state.id" readonly="readonly"></el-input>
      <el-input placeholder="제목을 입력해 주세요" v-model="title"></el-input>
      <el-input
        style="margin-top:30px;"
        type="textarea"
        :rows="30"
        placeholder="내용을 입력해 주세요."
        v-model="content"
      >
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="registboard()">확인</el-button>
        <el-button @click="openPopup = false">취소</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'RegistBoard',
  data() {
    return {
      openPopup: false,
      bno: '',
      editMode: false,
      title: '',
      content: '',
      writer:'',
    };
  },
  computed: {
    setParams() {
      const params = {
        bno: this.bno,
        title: this.title,
        content: this.content,
        writer: this.$store.state.id,
      };
      return params;
    },
    ModalTitle() {
      return this.editMode === true ? '글 수정' : '글 등록';
    },
  },
  methods: {
    registboard() {
      if (!this.editMode) {
        axios
          .post('http://localhost:8080/board/regist-board.do', this.setParams)
          .then((response) => {
            if (response.data.success || response.data.result) {
              this.openPopup = false;
              this.title = '';
              this.content = '';
              this.$emit('reload');
            }
          })
          .catch(function(error) {
            console.log(error);
          });
      }
      else {
        axios
          .post('http://localhost:8080/board/edit-board.do', this.setParams)
          .then((response) => {
            if (response.data.success || response.data.result) {
              this.openPopup = false;
              this.title = '';
              this.content = '';
              this.$emit('reload');
            }
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    },
  },
};
</script>

<style scoped></style>
