import request from '@/utils/request'

// 查询模板图片信息列表
export function listModelImage(query) {
  return request({
    url: '/modelImage/modelImage/list',
    method: 'get',
    params: query
  })
}

// 查询模板图片信息详细
export function getModelImage(id) {
  return request({
    url: '/modelImage/modelImage/' + id,
    method: 'get'
  })
}

// 新增模板图片信息
export function addModelImage(data) {
  return request({
    url: '/modelImage/modelImage',
    method: 'post',
    data: data
  })
}

// 修改模板图片信息
export function updateModelImage(data) {
  return request({
    url: '/modelImage/modelImage',
    method: 'put',
    data: data
  })
}

// 删除模板图片信息
export function delModelImage(id) {
  return request({
    url: '/modelImage/modelImage/' + id,
    method: 'delete'
  })
}

// 新增模板图片信息
export function saveModelImage(data) {
  return request({
    url: '/modelImage/modelImage/saveModel',
    method: 'post',
    data: data
  })
}
