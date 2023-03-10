import {Student} from './student.model';

describe('Student', () => {
  it('should create an instance', () => {
    expect(new Student('John', 'Doe', new Date('2000-01-01'), 'Male', 'example@email.com', '999888777', 'Address')).toBeTruthy();
  });
});
