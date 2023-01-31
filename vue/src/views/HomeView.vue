<template>
  <el-container style="border-left: 50px solid lightgray;border-right: 50px solid lightgray;height: 100% ;">
    <el-container style="height: 50px;">
<!--      <div class="line"></div>-->
      <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-menu-item index="1">系统推荐课程</el-menu-item>
        <el-menu-item index="2">方案内课程</el-menu-item>
        <el-menu-item index="3">方案外课程</el-menu-item>
        <el-menu-item index="4">校公选课/拓展英语</el-menu-item>
        <el-menu-item index="5">重修课程</el-menu-item>
        <el-menu-item index="6">体育课</el-menu-item>
        <el-menu-item index="7">辅修</el-menu-item>
      </el-menu>
      <el-header></el-header>
    </el-container>
    <el-container style="height: 400px;">
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-main style="height: 400px;">
        <div>
           <sfym style="margin-left: 10px">是否已满: </sfym>
          <template>
            <el-select v-model="value2" placeholder="请选择" style="width: 100px" @change="flagChange">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
          <kcsx style="margin-left: 10px">课程属性: </kcsx>
          <template>
            <el-select v-model="value3" placeholder="请选择" style="width: 100px" @change="attributeChange">
              <el-option
                  v-for="item in options1"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
          <kcxz style="margin-left: 10px">课程性质: </kcxz>
          <template>
            <el-select v-model="value4" placeholder="请选择" style="width: 200px" @change="natureChange">
              <el-option
                  v-for="item in options2"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
          <el-input style="width: 200px; margin-left: 10px" suffix-icon="el-icon-search" v-model="name"></el-input><el-button class="ml-5" @click="loadsearch">搜索</el-button>
        </div>
        <el-table :data="tableData" height="600">
          <el-table-column prop="idnumber" label="课程号" width="100">
          </el-table-column>
          <el-table-column prop="name" label="课程名" width="100">
          </el-table-column>
          <el-table-column prop="teacher" label="教师" width="100">
          </el-table-column>
          <el-table-column prop="time" label="时间地点" width="300">
          </el-table-column>
          <el-table-column prop="capacity" label="课容量" width="100">
          </el-table-column>
          <el-table-column prop="number" label="已选人数" width="100">
          </el-table-column>
          <el-table-column prop="nature" label="课程性质">
          </el-table-column>
          <el-table-column prop="attribute" label="课程属性">
          </el-table-column>
          <el-table-column prop="unit" label="开课单位">
          </el-table-column>
          <el-table-column prop="credit" label="学分">
          </el-table-column>
          <el-table-column prop="explain" label="课程说明">
          </el-table-column>
          <el-table-column
              fixed="right"
              label="操作">
            <template slot-scope="scope">
              <el-button type="text" size="small">编辑</el-button>
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block">
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              style="margin-left: 30%"
              :page-sizes="[2, 4, 8, 10]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
          </el-pagination>
        </div>
      </el-main>
    </el-container>
      <xinxi1 style="margin-left: 615px">（当前选课在线人数9人）</xinxi1>
    <el-footer style="margin-left: 480px">版权信息：© 2023 北理软工股份有限公司 京ICP备1111号</el-footer>
  </el-container>
</template>

<script>

export default {
  name: 'HomeView',
  data(){

    return{
      tableData: [],//表格数据
      total: 0,//表格数据条数
      name: "",//模糊查询中的课程名
      nature: "",//模糊查询中的课程性质
      attribute: "",//模糊查询中的课程属性
      flag:0,//模糊查询中判断是否为已满的标志，0为不筛选该部分，1为已满，2为未满
      pageNum: 1,//分页中的第几页
      pageSize: 4,//分页中的取多少条数据
      // msg:"hello Mu"
      options: [{
        value: '',
        label: '请选择'
      }, {
        value: '1',
        label: '是'
      }, {
        value: '2',
        label: '否'
      }],
      value2: '',

      options1: [{
        value: '',
        label: '请选择'
      }, {
        value: '必修',
        label: '必修'
      }, {
        value: '选修',
        label: '选修'
      }, {
        value: '任选',
        label: '任选'
      }, {
        value: '限选',
        label: '限选'
      }, {
        value: '校公选课',
        label: '校公选课'
      }],
      value3: '',

      options2: [{
        value: '',
        label: '请选择'
      }, {
        value: '公共基础课程',
        label: '公共基础课程'
      }, {
        value: '拓展英语',
        label: '拓展英语'
      }, {
        value: '专业基础课程',
        label: '专业基础课程'
      }, {
        value: '专业课',
        label: '专业课'
      }, {
        value: '平台基础',
        label: '平台基础'
      }, {
        value: '校公选课',
        label: '校公选课'
      }, {
        value: '体育课',
        label: '体育课'
      }, {
        value: '实践环节',
        label: '实践环节'
      }, {
        value: '大类基础',
        label: '大类基础'
      }, {
        value: '基础教育',
        label: '基础教育'
      }],
      value4: '',
    }
  },
  created() {
    //请求分页查询数据
    this.loadsearch()
  },
  methods:{
    //请求分页查询函数
    loadsearch(){
      this.request.get("http://localhost:9090/search",{
        params:{
          name:this.name,
          nature:this.nature,
          attribute:this.attribute,
          flag:this.flag,
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data
        this.total = res.total
      })
    },

    //以下两个函数为分页后，更改页数以及每页数据数后重新请求数据
    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize=pageSize
      this.loadsearch()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum=pageNum
      this.loadsearch()
    },

    //改函数为改变课程性质后重新请求数据
    natureChange(value){
      console.log(value)
      this.nature=value
      this.loadsearch()
    },

    //改函数为改变课程属性后重新请求数据
    attributeChange(value){
      console.log(value)
      this.attribute=value
      this.loadsearch()
    },

    //改函数为改变是否已满后重新请求数据
    flagChange(value){
      console.log(value)
      if(value=="1"){
        this.flag=1
      }
      else if(value=="2"){
        this.flag=2
      }
      else{
        this.flag=0
      }
      this.loadsearch()
    },
  }
}
</script>
