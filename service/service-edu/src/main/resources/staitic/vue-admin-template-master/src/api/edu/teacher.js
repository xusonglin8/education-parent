import request from '@/utils/request'

export default {
  getTeacherList(current,limit,teacherQuery){
    return request({
      url: '/eduservice/edu-teacher/pageTeacherByCondition/' + current + "/" + limit,
      method: 'post',
      data: teacherQuery
    })
  },

  removeTeacherById(id) {
    return request({
      url: '/eduservice/edu-teacher/deleteById/' + id,
      method: 'delete'
    })
  },

  addTeacher(eduTeacher){
    return request({
      url: '/eduservice/edu-teacher/addTeacher/',
      method: 'post',
      data: eduTeacher
    })
  },

  updateTeacherInfo(eduTeacher){
    return request({
      url: '/eduservice/edu-teacher/updateEduTeacher/',
      method: 'post',
      data: eduTeacher
    })
  },

  getTeacherInfo(id){
    return request({
      url: '/eduservice/edu-teacher/getEduTeacherById/'+id,
      method: 'get'
    })
  }
}
