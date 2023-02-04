<template>
  <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      router>
    <el-menu-item index="/SystemRecommend">系统推荐课程</el-menu-item>
    <el-menu-item index="2" disabled>方案内课程</el-menu-item>
    <el-menu-item index="3" disabled>方案外课程</el-menu-item>
    <el-menu-item index="/ElectiveCourses">校公选课/拓展英语</el-menu-item>
    <el-menu-item index="5" disabled>重修课程</el-menu-item>
    <el-menu-item index="/PEclass">体育课</el-menu-item>
    <el-menu-item index="/Minor">辅修</el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>