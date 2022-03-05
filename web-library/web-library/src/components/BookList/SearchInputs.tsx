import { Form, Input, Select, Row, Col } from 'antd';
import { categoryType } from '@/pages/BookManagement';
const SearchInputs: React.FC = () => {
  return (
    <>
      <Col span={6}>
        <Form.Item name="sBookName" label="书名" labelCol={{ span: 6 }}>
          <Input />
        </Form.Item>
      </Col>
      <Col span={6}>
        <Form.Item name="sSubTitle" label="副标题" labelCol={{ span: 6 }}>
          <Input />
        </Form.Item>
      </Col>
      <Col span={6}>
        <Form.Item name="sCategoryId" label="类别" labelCol={{ span: 6 }}>
          <Select>
            {categoryType.map((c) => {
              return (
                <Select.Option
                  key={categoryType.indexOf(c) + 1}
                  value={categoryType.indexOf(c) + 1}
                >
                  {c}
                </Select.Option>
              );
            })}
          </Select>
        </Form.Item>
      </Col>
      <Col span={6}>
        <Form.Item name="sAuthor" label="作者" labelCol={{ span: 6 }}>
          <Input />
        </Form.Item>
      </Col>
    </>
  );
};
export default SearchInputs;
