<template>
<!--  <div>-->
<!--    <el-container style="height: 100%;">-->
<!--      <el-aside width="200px" style="background-color: rgb(238, 241, 246); height: 100%">-->
<!--        <el-menu :default-openeds="['1', '3']">-->
<!--          <el-submenu index="1">-->
<!--            <template slot="title"><i class="el-icon-message"></i>导航一</template>-->
<!--            <el-menu-item-group>-->
<!--              <template slot="title">分组一</template>-->
<!--              <el-menu-item index="1-1">选项1</el-menu-item>-->
<!--              <el-menu-item index="1-2">选项2</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="1-3">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="1-4">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="1-4-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--          <el-submenu index="2">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>导航二</template>-->
<!--            <el-menu-item-group>-->
<!--              <template slot="title">分组一</template>-->
<!--              <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--              <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="2-4">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--          <el-submenu index="3">-->
<!--            <template slot="title"><i class="el-icon-setting"></i>导航三</template>-->
<!--            <el-menu-item-group>-->
<!--              <template slot="title">分组一</template>-->
<!--              <el-menu-item index="3-1">选项1</el-menu-item>-->
<!--              <el-menu-item index="3-2">选项2</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="3-3">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="3-4">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--        </el-menu>-->
<!--      </el-aside>-->

<!--      <el-container>-->
<!--        <el-header style="text-align: right; font-size: 12px; line-height: 60px">-->
<!--          <el-dropdown>-->
<!--            <i class="el-icon-setting" style="margin-right: 15px"></i>-->
<!--            <el-dropdown-menu slot="dropdown">-->
<!--              <el-dropdown-item>查看</el-dropdown-item>-->
<!--              <el-dropdown-item>新增</el-dropdown-item>-->
<!--              <el-dropdown-item>删除</el-dropdown-item>-->
<!--            </el-dropdown-menu>-->
<!--          </el-dropdown>-->
<!--          <span>王小虎</span>-->
<!--        </el-header>-->

<!--        <el-main>-->
<!--          <el-table :data="tableData">-->
<!--            <el-table-column prop="date" label="日期" width="140">-->
<!--            </el-table-column>-->
<!--            <el-table-column prop="name" label="姓名" width="120">-->
<!--            </el-table-column>-->
<!--            <el-table-column prop="address" label="地址">-->
<!--            </el-table-column>-->
<!--          </el-table>-->
<!--        </el-main>-->
<!--      </el-container>-->
<!--    </el-container>-->
<!--  </div>-->
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
<!--        <el-menu-item index="1" ></el-menu-item>-->
<!--        <el-submenu index="2"></el-submenu>-->
<!--        <el-menu-item index="3" >消息中心</el-menu-item>-->
<!--        <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>-->
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
          <ct>冲突: </ct>
          <template>
            <el-select v-model="value1" placeholder="请选择" style="width: 100px">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
           <sfym style="margin-left: 10px">是否已满: </sfym>
          <template>
            <el-select v-model="value2" placeholder="请选择" style="width: 100px">
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
            <el-select v-model="value3" placeholder="请选择" style="width: 100px">
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
            <el-select v-model="value4" placeholder="请选择" style="width: 200px">
              <el-option
                  v-for="item in options2"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </template>
          <el-input style="width: 200px; margin-left: 10px" suffix-icon="el-icon-search"></el-input><el-button class="ml-5">搜索</el-button>
        </div>
        <el-table :data="tableData" height="600">
          <el-table-column prop="id" label="课程号" width="100">
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
        </el-table>
        <div >
          <el-pagination
              style="margin-left: 37%"
              layout="prev, pager, next"
              :total="1000">
          </el-pagination>
        </div>
      </el-main>
    </el-container>
<!--    <el-main style="height: 600px;">Main</el-main>-->
      <xinxi1 style="margin-left: 615px">（当前选课在线人数9人）</xinxi1>
    <el-footer style="margin-left: 480px">版权信息：© 2023 北理软工股份有限公司 京ICP备1111号</el-footer>
  </el-container>
</template>

<script>

export default {
  name: 'HomeView',
  data(){
    const item = {
      id: '100083017',
      name: '毕业设计',
      teacher:'张三',
      time:'2-3周 星期一 11-13节 3号楼312\n' +
          '4周 星期六 2-9节 5号楼427\n' +
          '4周 星期日 2-9节 5号楼427\n' +
          '5周,8周 星期一 11-13节 5号楼417\n' +
          '6周 星期一 11-13节 5号楼1005\n' +
          '7周 星期一 11-13节 5号楼427\n' +
          '9周 星期一 11-13节 5号楼415',
      capacity:'30',
      number:'0',
      nature:'实践环节',
      attribute:'必修',
      unit:'计算机学院',
      credit:'8',
      explain:''
    };
    return{
      tableData: Array(4).fill(item),
      // msg:"hello Mu"
      options: [{
        value: '选项1',
        label: '请选择'
      }, {
        value: '选项2',
        label: '是'
      }, {
        value: '选项3',
        label: '否'
      }],
      value1: '',
      value2: '',

      options1: [{
        value: '选项1',
        label: '请选择'
      }, {
        value: '选项2',
        label: '必修'
      }, {
        value: '选项3',
        label: '选修'
      }, {
        value: '选项4',
        label: '任选'
      }, {
        value: '选项5',
        label: '限选'
      }, {
        value: '选项6',
        label: '校公选课'
      }],
      value3: '',

      options2: [{
        value: '选项1',
        label: '请选择'
      }, {
        value: '选项2',
        label: '公共基础课程'
      }, {
        value: '选项3',
        label: '拓展英语'
      }, {
        value: '选项4',
        label: '专业基础课程'
      }, {
        value: '选项5',
        label: '专业课'
      }, {
        value: '选项6',
        label: '平台基础'
      }, {
        value: '选项7',
        label: '校公选课'
      }, {
        value: '选项8',
        label: '体育课'
      }, {
        value: '选项9',
        label: '实践环节'
      }, {
        value: '选项10',
        label: '大类基础'
      }, {
        value: '选项11',
        label: '基础教育'
      }],
      value4: '',
    }
  }
}
</script>
