<template>
  <div id="eduTeacherContain"
       v-loading="listLoading"
       element-loading-text="拼命加载中"
       element-loading-spinner="el-icon-loading">
    <el-form :inline="true"  class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="teacherQuery.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-select v-model="teacherQuery.level" placeholder="讲师头衔">
          <el-option label="高级讲师" :value="1"></el-option>
          <el-option label="首席讲师" :value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间">
        <el-date-picker
          v-model="teacherQuery.begin"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"></el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间">
        <el-date-picker
          v-model="teacherQuery.end"
          type="datetime" placeholder="选择结束时间" value-format="yyyy-MM-dd HH:mm:ss" default-time="00:00:00"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search"  @click="getList()">查询</el-button>
        <el-button type="default" @click="clearSearch">清空</el-button>
      </el-form-item>
    </el-form>

  <el-table
    :data="list"
    ref="multipleTable"
    style="width: 100%"
    @selection-change="">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      label="序号"
      width="70"
      align="center">
      <template slot-scope="scope">
        {{(page - 1)* limit + scope.$index + 1}}
      </template>
    </el-table-column>
    <el-table-column
      label="入职时间"
      width="180"
      align="center">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.gmtCreate}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="姓名"
      width="180"
      align="center">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>姓名: {{ scope.row.name }}</p>
          <p>个人简介: {{ scope.row.intro }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.name }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column
      label="资历"
      width="180"
      align="center">
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.career}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="职称"
      width="180"
      align="center">
      <template slot-scope="scope">
        <span style="margin-left: 10px">{{ scope.row.level==1?'高级讲师':'首席讲师'}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="头像"
      width="180"
      align="center">
      <template slot-scope="scope">
        <img :src="scope.row.avatar" style="width:100px;height:100px">
      </template>
    </el-table-column>
    <el-table-column label="操作" align="center">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="editTeacher(scope.row.id)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="removeTeacher(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

    <el-pagination
      background
      @current-change="getList"
      :current-page.sync="page"
      :page-size="limit"
      layout="total,prev, pager, next, jumper"
      :total="total"
      style="padding:30px 0;text-align: center">
    </el-pagination>
  </div>
</template>
<script>
  import teacher from "@/api/edu/teacher";

  export default {
      data(){
          return{
              total: null,
              listLoading: true,
              list: null,
              page: 1,
              limit: 3,
              teacherQuery: {}
          }
      },
      created() {
          this.getList()
      },
      methods:{
          clearSearch(){
              this.teacherQuery = {};
          },
          getList(page=1){
              this.page = page;
              teacher.getTeacherList(this.page,this.limit,this.teacherQuery)
                  .then(response => {
                      this.list = response.data.rows;
                      this.total = response.data.total;
                      this.listLoading = false;
                  })
          },
          removeTeacher(id){
              this.$confirm('此操作将永久删除讲师记录, 是否继续?', '提示', {
                  confirmButtonText: '确定',
                  cancelButtonText: '取消',
                  type: 'warning'})
                  .then(response => {
                      teacher.removeTeacherById(id)
                          .then(response => {
                              this.$message({
                                  type:"success",
                                  message:"删除成功"
                              })
                              this.getList()
                          })
                  })
          },
          editTeacher(id){
              this.$router.push({path:'/teacher/addTeacher',query:{id : id}})
          }
      }
  }
</script>
