import request from '@/utils/request'

// 查询颜色信息列表
export function listColorInfo(query) {
  return request({
    url: '/colorInfo/colorInfo/list',
    method: 'get',
    params: query
  })
}

// 查询颜色信息详细
export function getColorInfo(id) {
  return request({
    url: '/colorInfo/colorInfo/' + id,
    method: 'get'
  })
}

// 查询颜色信息列表
export function listToShow() {
  return request({
    url: '/colorInfo/colorInfo/listToShow',
    method: 'post',
  })
}

// 新增颜色信息
export function addColorInfo(data) {
  return request({
    url: '/colorInfo/colorInfo',
    method: 'post',
    data: data
  })
}

// 修改颜色信息
export function updateColorInfo(data) {
  return request({
    url: '/colorInfo/colorInfo',
    method: 'put',
    data: data
  })
}

// 删除颜色信息
export function delColorInfo(id) {
  return request({
    url: '/colorInfo/colorInfo/' + id,
    method: 'delete'
  })
}
