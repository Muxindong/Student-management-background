<template>
  <el-container style="border-left: 50px solid lightgray;border-right: 50px solid lightgray;height: 100% ;">

      <el-header>
        <Aside/>
      </el-header>

      <el-main>
<!--        表示当前页面的子路由会在 <router-view> 里展示-->
        <router-view/>
      </el-main>

      <el-footer>
        <Footer/>
      </el-footer>

  </el-container>
</template>

<script>

import Aside from "@/components/Aside";
import Footer from "@/components/Footer";

export default {
  name: 'HomeView',
  data(){
    return{
      // msg:"hello Mu"
    }
  },
  // created() {
  //   //请求分页查询数据
  //   this.loadsearch()
  // },
  components:{
    Aside,
    Footer
  },
  methods:{

  }
}
</script>
