import React, { useEffect, useState } from 'react';
import { Form, Input, Select } from 'antd';
import { categoryType } from '@/pages/BookManagement';
import TextArea from 'antd/lib/input/TextArea';
const BookForm: React.FC = () => {
  return (
    <>
      <Form.Item name="bookName" label="书名" labelCol={{ span: 6 }} rules={[{ required: true }]}>
        <Input />
      </Form.Item>
      <Form.Item name="subTitle" label="副标题" labelCol={{ span: 6 }} rules={[{ required: true }]}>
        <Input />
      </Form.Item>
      <Form.Item name="categoryId" label="类别" labelCol={{ span: 6 }} rules={[{ required: true }]}>
        <Select>
          {categoryType.map((c) => {
            return (
              <Select.Option key={categoryType.indexOf(c) + 1} value={categoryType.indexOf(c) + 1}>
                {c}
              </Select.Option>
            );
          })}
        </Select>
      </Form.Item>
      <Form.Item name="author" label="作者" labelCol={{ span: 6 }} rules={[{ required: true }]}>
        <Input />
      </Form.Item>
      <Form.Item name="description" label="描述" labelCol={{ span: 6 }}>
        <TextArea showCount maxLength={100} style={{ height: 120 }} />
      </Form.Item>
    </>
  );
};
export default BookForm;
