import React, { FunctionComponent } from 'react';

interface OwnProps {}

type Props = OwnProps;

const TestPage: FunctionComponent<Props> = ( props) => {

  return (
      <div>
        <p>Hola</p>
      </div>
  );
};

export default TestPage;
