<template>
  <div class="wrapper">
    <div style="margin: 200px auto;background-color: #fff;width: 350px;height: 300px;padding: 20px;border-radius: 10px">
      <div style="margin: 20px 0;text-align: center;font-size: 24px"><b>登录</b></div>
      <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.account"></el-input>
      <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
      <div style="primary:10px 0; text-align:right">
        <el-button type="primary" size="small" autocomplete="off" @click="login">登录</el-button>
        <el-button type="warning" size="small" autocomplete="off" @click="register">注册</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      user:{}
    }
  },
  methods:{
    login(){
      this.request.post("http://localhost:9090/teacher/login" ,this.user).then(res =>{
        console.log(res)
        if(res.exist&&res.illegal){
          this.$message.success("登录成功")
          this.$router.push("/")
        }
        else if(!res.illegal){
          this.$message.error("请输入合法的密码（大写字母+小写字母+数字+下划线组合）")
        }
        else{
          this.$message.error("请输入正确的账号及密码")
        }
      })
    },
    register(){
      this.request.post("http://localhost:9090/teacher/register" ,this.user).then(res =>{
        console.log(res)
        if(!res.illegal){
          this.$message.error("请输入合法的密码（大写字母+小写字母+数字+下划线组合）")
        }
        else if(res.exist){
          this.$message.error("账号已存在")
        }
        else{
          this.$message.success("注册成功")
        }
      })
    }
  }
}
</script>

<style>
  .wrapper{
    height: 100vh;
    background-image: linear-gradient(to bottom right, #ffffff , #3F5EFB);
    overflow: hidden;
  }
</style>