import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditEmpTemplateDriveComponent } from './edit-emp-template-drive.component';

describe('EditEmpTemplateDriveComponent', () => {
  let component: EditEmpTemplateDriveComponent;
  let fixture: ComponentFixture<EditEmpTemplateDriveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditEmpTemplateDriveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditEmpTemplateDriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
