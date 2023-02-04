<template>
  <div>
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
      <el-button class="ml-5" @click="handleAdd">增添</el-button>
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
          <el-button type="text" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm
              style="margin-left:5px"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="handleDelete(scope.row.id)"
          >
            <el-button type="text" size="small" slot="reference">删除</el-button>
          </el-popconfirm>
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

    <el-dialog title="课程信息" :visible.sync="dialogFormVisible" center width="30%">
      <el-form label-width="80px">
        <el-form-item label="课程号">
          <el-input v-model="form.idnumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程名">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="教师">
          <el-input v-model="form.teacher" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="时间地点">
          <el-input v-model="form.time" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课容量">
          <el-input v-model="form.capacity" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="已选人数">
          <el-input v-model="form.number" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程性质">
          <el-input v-model="form.nature" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程属性">
          <el-input v-model="form.attribute" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="开课单位">
          <el-input v-model="form.unit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学分">
          <el-input v-model="form.credit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="课程说明">
          <el-input v-model="form.explain" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveHandleAdd">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "PEclass",
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
      types: 1,
      dialogFormVisible: false,
      form: {},
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

    //该函数为新增数据时初始化以及显示弹窗
    handleAdd(){
      this.dialogFormVisible = true
      this.form = {}
      this.form.id = this.id
      this.form.types = this.types
    },
    //新增函数
    saveHandleAdd(){
      this.request.post("http://localhost:9090/adduser" ,this.form).then(res =>{
        console.log(res)
        if(res){
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.loadsearch()
        }
        else{
          this.$message.error("保存失败")
        }
      })
    },

    //编辑时获取改id对应的信息
    handleEdit(row){
      this.form = row
      this.dialogFormVisible = true
    },

    //编辑功能函数
    handleDelete(id){
      this.request.delete("http://localhost:9090/deleteuser",{params:{id}}).then(res=>{
        console.log(res)
        if(res){
          this.$message.success("删除成功")
          this.loadsearch()
        }
        else{
          this.$message.error("删除失败")
        }
      })
    }
  }
}
</script>

<style scoped>

</style>